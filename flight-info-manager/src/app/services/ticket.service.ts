import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Passenger} from "../models/passenger.model";
import {Flight} from "../models/flight.model";
import {Airport} from "../models/airport.model";
import {Aircraft} from "../models/aircraft.model";
import {Ticket} from "../models/ticket.model";

const baseUrl = 'http://localhost:4200/api/v1/tickets';
const deleteUrl = 'http://localhost:4200/tickets';

@Injectable({
  providedIn: 'root',
})
export class TicketService {
  constructor(private http: HttpClient) {}

  getAllForPassenger(id: any): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(baseUrl + `/${id}`);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${deleteUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(deleteUrl);
  }
}
