import {Airport} from "./airport.model";
import {Aircraft} from "./aircraft.model";

export class Flight {
  id?: number;
  flightNumber?: string;
  departureAirport?: Airport;
  arrivalAirport?: Airport;
  departureTime?: string;
  arrivalTime?: string;
  aircraft?: Aircraft;
  baseFare?: number;
}
