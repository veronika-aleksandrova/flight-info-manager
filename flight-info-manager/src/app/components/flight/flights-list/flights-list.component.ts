import { Component, OnInit } from '@angular/core';
import {FlightService} from "../../../services/flight.service";
import {Flight} from "../../../models/flight.model";

@Component({
  selector: 'app-flights-list',
  templateUrl: './flights-list.component.html',
  styleUrls: ['./flights-list.component.css'],
})
export class FlightsListComponent {
  flights?: Flight[];
  filteredFlights?: Flight[];
  currentFlight: Flight = {};
  currentIndex = -1;
  firstName = '';

  constructor(private flightService: FlightService) {}

  ngOnInit(): void {
    this.retrieveFlights();
  }

  retrieveFlights(): void {
    this.flightService.getAll().subscribe({
      next: (data) => {
        // @ts-ignore
        this.flights = data["_embedded"].flights;

        // @ts-ignore
        this.flights.forEach(flight => {
          this.flightService.getDepartureAirport(flight.id).subscribe({
            next: (data) => {
              // @ts-ignore
              flight.departureAirport = data;
            },
            error: (e) => console.error(e)
          });

          this.flightService.getArrivalAirport(flight.id).subscribe({
            next: (data) => {
              // @ts-ignore
              flight.arrivalAirport = data;
            },
            error: (e) => console.error(e)
          });

          this.flightService.getAircraft(flight.id).subscribe({
            next: (data) => {
              // @ts-ignore
              flight.aircraft = data;
            },
            error: (e) => console.error(e)
          });
        })

        this.filteredFlights = this.flights;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.retrieveFlights();
    this.currentFlight = {};
    this.currentIndex = -1;
  }

  setActiveFlight(flight: Flight, index: number): void {
    this.currentFlight = flight;
    this.currentIndex = index;
  }

  removeAllFlights(): void {
    this.flightService.deleteAll().subscribe({
      next: (res) => {
        console.log(res);
        this.refreshList();
      },
      error: (e) => console.error(e)
    });
  }

  searchFlight(text: string): void {
    this.currentFlight = {};
    this.currentIndex = -1;

    if (!text) {
      this.filteredFlights = this.flights;
      return;
    }

    // @ts-ignore
    this.filteredFlights = this.flights.filter(
    // @ts-ignore
      flight => flight?.flightNumber.toLowerCase().includes(text.toLowerCase())
    );
  }
}
