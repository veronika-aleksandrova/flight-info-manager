import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PassengersListComponent} from "./components/passenger/passengers-list/passengers-list.component";
import {PassengerDetailsComponent} from "./components/passenger/passenger-details/passenger-details.component";
import {AddPassengerComponent} from "./components/passenger/add-passenger/add-passenger.component";
import {FlightsListComponent} from "./components/flight/flights-list/flights-list.component";
import {FlightDetailsComponent} from "./components/flight/flight-details/flight-details.component";
import {TicketDetailsComponent} from "./components/ticket-details/ticket-details.component";

const routes: Routes = [
  { path: '', redirectTo: 'passengers', pathMatch: 'full' },
  { path: 'passengers/add', component: AddPassengerComponent },
  { path: 'passengers/:id', component: PassengerDetailsComponent },
  { path: 'passengers', component: PassengersListComponent },
  { path: 'flights', component: FlightsListComponent },
  { path: 'flights/:id', component: FlightDetailsComponent },
  { path: 'tickets/:id', component: TicketDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
