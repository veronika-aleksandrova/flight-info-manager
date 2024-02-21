import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Passenger} from "../../../models/passenger.model";
import {PassengerService} from "../../../services/passenger.service";

@Component({
  selector: 'app-passenger-details',
  templateUrl: './passenger-details.component.html',
  styleUrls: ['./passenger-details.component.css'],
})
export class PassengerDetailsComponent {
  @Input() viewMode = false;

  @Input() currentPassenger: Passenger = {
    firstName: '',
    lastName: '',
    emailAddress: '',
    phoneNumber: ''
  };

  message = '';

  constructor(
    private passengerService: PassengerService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getPassenger(this.route.snapshot.params['id']);
    }
  }

  getPassenger(id: string): void {
    this.passengerService.get(id).subscribe({
      next: (data) => {
        // @ts-ignore
        // this.currentPassenger = data["_embedded"].passengers;
        this.currentPassenger = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  updatePassenger(): void {
    this.message = '';

    this.passengerService
      .update(this.currentPassenger.id, this.currentPassenger)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message
            ? res.message
            : 'This passenger was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deletePassenger(): void {
    this.passengerService.delete(this.currentPassenger.id).subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigate(['/passengers']);
      },
      error: (e) => console.error(e)
    });
  }

  getTickets(): void {
      this.router.navigate(['/tickets/' + this.route.snapshot.params['id']]);
  }
}
