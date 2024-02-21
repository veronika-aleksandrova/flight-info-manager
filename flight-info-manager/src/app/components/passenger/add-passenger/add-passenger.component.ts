import {Component} from '@angular/core';
import {Passenger} from "../../../models/passenger.model";
import {PassengerService} from "../../../services/passenger.service";

@Component({
  selector: 'app-add-passenger',
  templateUrl: './add-passenger.component.html',
  styleUrls: ['./add-passenger.component.css'],
})
export class AddPassengerComponent {
  passenger: Passenger = {
    firstName: '',
    lastName: '',
    emailAddress: '',
    phoneNumber: ''
  };
  submitted = false;

  constructor(private passengerService: PassengerService) {
  }

  savePassenger(): void {
    const data = {
      firstName: this.passenger.firstName,
      lastName: this.passenger.lastName,
      emailAddress: this.passenger.emailAddress,
      phoneNumber: this.passenger.phoneNumber
    };

    this.passengerService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
  }

  newPassenger(): void {
    this.submitted = false;
    this.passenger = {
      firstName: '',
      lastName: '',
      emailAddress: '',
      phoneNumber: ''
    };
  }
}
