import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {FlightService} from "../../../services/flight.service";
import {Flight} from "../../../models/flight.model";

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css'],
})
export class FlightDetailsComponent {
  @Input() viewMode = false;

  @Input() currentFlight: Flight = {
    flightNumber: '',
    departureTime: '',
    arrivalTime: '',
    baseFare: 0,
  };

  departureIata: string | undefined;
  arrivalIata: string | undefined;
  aircraftType: string | undefined;

  message = '';

  constructor(
    private flightService: FlightService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getFlight(this.route.snapshot.params['id']);
    }
  }

  getFlight(id: string): void {
    this.flightService.get(id).subscribe({
      next: (data) => {
        this.currentFlight = data;

        // @ts-ignore

        this.flightService.getDepartureAirport(id).subscribe({
          next: (data) => {
            // @ts-ignore
            this.currentFlight.departureAirport = data;
            this.departureIata = data.iataCode;
          },
          error: (e) => console.error(e)
        });

        this.flightService.getArrivalAirport(id).subscribe({
          next: (data) => {
            // @ts-ignore
            this.currentFlight.arrivalAirport = data;
            this.arrivalIata = data.iataCode;
          },
          error: (e) => console.error(e)
        });

        this.flightService.getAircraft(id).subscribe({
          next: (data) => {
            // @ts-ignore
            this.currentFlight.aircraft = data;
            this.aircraftType = data.aircraftType;
          },
          error: (e) => console.error(e)
        });

        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  updateFlight(): void {
    this.message = '';

    this.flightService
      .update(this.currentFlight.id, this.currentFlight)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message
            ? res.message
            : 'This flight was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteFlight(): void {
    this.flightService.delete(this.currentFlight.id).subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigate(['/flights']);
      },
      error: (e) => console.error(e)
    });
  }
}
