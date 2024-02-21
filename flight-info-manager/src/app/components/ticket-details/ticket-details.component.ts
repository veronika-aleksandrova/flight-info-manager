import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Ticket} from "../../models/ticket.model";
import {TicketService} from "../../services/ticket.service";
import {Flight} from "../../models/flight.model";
import {Passenger} from "../../models/passenger.model";

@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.css'],
})
export class TicketDetailsComponent {

  @Input()
  currentPassenger: Passenger = {
    firstName: '',
    lastName: '',
    emailAddress: '',
    phoneNumber: ''
  };

  tickets?: Ticket[];
  currentTicket: Ticket = {};
  currentIndex = -1;

  constructor(
    private ticketService: TicketService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getTickets(this.route.snapshot.params['id']);
  }

  setActiveTicket(ticket: Ticket, index: number): void {
    this.currentTicket = ticket;
    this.currentIndex = index;
  }

  getTickets(id: string): void {
    this.ticketService.getAllForPassenger(id).subscribe({
      next: (data) => {
        this.tickets = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }


  deleteTicket(id: any): void {
    this.ticketService.delete(id).subscribe({
      next: (res) => {
        console.log(res);
        this.refreshList();
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.getTickets(this.route.snapshot.params['id']);
    this.currentTicket = {};
    this.currentIndex = -1;
  }

  deleteAll(): void {
    this.ticketService.deleteAll().subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigate(['/passengers']);
      },
      error: (e) => console.error(e)
    });
  }
}
