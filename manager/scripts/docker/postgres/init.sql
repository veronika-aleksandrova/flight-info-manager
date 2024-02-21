create database flight_info;

CREATE TABLE if not exists Flights
(
    FlightID           INTEGER PRIMARY KEY,
    FlightNumber       VARCHAR(10)    NOT NULL,
    DepartureAirportID INT            NOT NULL,
    ArrivalAirportID   INT            NOT NULL,
    DepartureTime      DATE           NOT NULL,
    ArrivalTime        DATE           NOT NULL,
    AircraftID         INT            NOT NULL,
    BaseFare           DECIMAL(10, 2) NOT NULL
);

CREATE TABLE if not exists Passengers
(
    PassengerID  INT PRIMARY KEY,
    FirstName    VARCHAR(50)  NOT NULL,
    LastName     VARCHAR(50)  NOT NULL,
    EmailAddress VARCHAR(100) NOT NULL,
    PhoneNumber  VARCHAR(20)
);

CREATE TABLE if not exists Tickets
(
    TicketID      INT PRIMARY KEY,
    PassengerID   INT            NOT NULL,
    FlightID      INT            NOT NULL,
    SeatNumber    VARCHAR(5),
    PurchaseDate  DATE           NOT NULL,
    PurchasePrice DECIMAL(10, 2) NOT NULL
);

CREATE TABLE if not exists Airports
(
    AirportID   INT PRIMARY KEY,
    AirportName VARCHAR(50) NOT NULL,
    City        VARCHAR(50) NOT NULL,
    Country     VARCHAR(50) NOT NULL,
    IATACode    VARCHAR(3)  NOT NULL
);

CREATE TABLE if not exists Aircraft
(
    AircraftID    INT PRIMARY KEY,
    AircraftType  VARCHAR(50) NOT NULL,
    Manufacturer  VARCHAR(50) NOT NULL,
    NumberOfSeats INT         NOT NULL
);

ALTER TABLE Flights
    ADD FOREIGN KEY (DepartureAirportID) REFERENCES Airports (AirportID),
    ADD FOREIGN KEY (ArrivalAirportID) REFERENCES Airports (AirportID),
    ADD FOREIGN KEY (AircraftID) REFERENCES Aircraft (AircraftID);

ALTER TABLE Tickets
    ADD FOREIGN KEY (PassengerID) REFERENCES Passengers (PassengerID),
    ADD FOREIGN KEY (FlightID) REFERENCES Flights (FlightID);
