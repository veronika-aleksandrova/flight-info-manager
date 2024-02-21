import { Component, OnInit } from '@angular/core';
import {Passenger} from "../../../models/passenger.model";
import {PassengerService} from "../../../services/passenger.service";

@Component({
  selector: 'app-passengers-list',
  templateUrl: './passengers-list.component.html',
  styleUrls: ['./passengers-list.component.css'],
})
export class PassengersListComponent {
  passengers?: Passenger[];
  filteredPassengers?: Passenger[];
  currentPassenger: Passenger = {};
  currentIndex = -1;
  firstName = '';

  constructor(private passengerService: PassengerService) {}

  ngOnInit(): void {
    this.retrievePassengers();
  }

  retrievePassengers(): void {
    this.passengerService.getAll().subscribe({
      next: (data) => {
        // @ts-ignore
        this.passengers = data["_embedded"].passengers;
        this.filteredPassengers = this.passengers;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.retrievePassengers();
    this.currentPassenger = {};
    this.currentIndex = -1;
  }

  setActivePassenger(passenger: Passenger, index: number): void {
    this.currentPassenger = passenger;
    this.currentIndex = index;
  }

  removeAllPassengers(): void {
    this.passengerService.deleteAll().subscribe({
      next: (res) => {
        console.log(res);
        this.refreshList();
      },
      error: (e) => console.error(e)
    });
  }

  searchName(text: string): void {
    this.currentPassenger = {};
    this.currentIndex = -1;

    if (!text) {
      this.filteredPassengers = this.passengers;
      return;
    }

    // @ts-ignore
    this.filteredPassengers = this.passengers.filter(
    // @ts-ignore
      passenger => passenger?.firstName.toLowerCase().includes(text.toLowerCase())
    );
  }
}
