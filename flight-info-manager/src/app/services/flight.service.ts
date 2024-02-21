import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Passenger} from "../models/passenger.model";
import {Flight} from "../models/flight.model";
import {Airport} from "../models/airport.model";
import {Aircraft} from "../models/aircraft.model";

const baseUrl = 'http://localhost:4200/api/v1/flights';

@Injectable({
  providedIn: 'root',
})
export class FlightService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Flight[]> {
    return this.http.get<Flight[]>(baseUrl);
  }

  get(id: any): Observable<Flight> {
    return this.http.get<Flight>(`${baseUrl}/${id}`);
  }

  getDepartureAirport(id: any): Observable<Airport> {
    return this.http.get<Flight>(`${baseUrl}/${id}/departureAirport`);
  }

  getArrivalAirport(id: any): Observable<Airport> {
    return this.http.get<Flight>(`${baseUrl}/${id}/arrivalAirport`);
  }

  getAircraft(id: any): Observable<Aircraft> {
    return this.http.get<Flight>(`${baseUrl}/${id}/aircraft`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }
}
