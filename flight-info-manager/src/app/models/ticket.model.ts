import {Passenger} from "./passenger.model";
import {Flight} from "./flight.model";

export class Ticket {
  id?: number;
  passenger?: Passenger;
  flight?: Flight;
  seatNumber?: string;
  purchaseDate?: string;
  purchasePrice?: number;
}
