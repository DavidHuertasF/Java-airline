package models;

import java.util.Calendar;

public class Flight {
    private int id;
    private String name;
    private Pilot[] pilotList;
    private City destination;
    private City origin;
    private int arrivalTime;
    private int departureTime;
    private Booking[] bookingList;
    private AirPlane airPlane;

    public Flight(int id, City destination, City origin, int arrivalTime, int departureTime, AirPlane airPlane) {
        this.id = id;
        this.name = name;
        this.pilotList =  new Pilot [10];
        this.destination = destination;
        this.origin = origin;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.bookingList = new Booking[10];
        this.airPlane = airPlane;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Pilot[] getPilotList() {
        return pilotList;
    }

    public City getDestination() {
        return destination;
    }

    public City getOrigin() {
        return origin;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public Booking[] getBookingList() {
        return bookingList;
    }

    public AirPlane getAirPlane() {
        return airPlane;
    }
    
    public void assignPilot(){
    } 
    
    public void assignBooking(Booking booking){
    } 
    
    public void assignAirplane(){
        
    } 

}

