import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {PassengersListComponent} from "./components/passenger/passengers-list/passengers-list.component";
import {PassengerDetailsComponent} from "./components/passenger/passenger-details/passenger-details.component";
import {AddPassengerComponent} from "./components/passenger/add-passenger/add-passenger.component";
import {FlightsListComponent} from "./components/flight/flights-list/flights-list.component";
import {FlightDetailsComponent} from "./components/flight/flight-details/flight-details.component";
import {TicketDetailsComponent} from "./components/ticket-details/ticket-details.component";

@NgModule({
  declarations: [
    AppComponent,
    AddPassengerComponent,
    PassengerDetailsComponent,
    PassengersListComponent,
    FlightDetailsComponent,
    FlightsListComponent,
    TicketDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
