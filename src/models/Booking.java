package models;

public class Booking {
    private int id;
    private int weight;
    private City origin;
    private City destination;
    private Passenger passenger;
    private ClassType classType;
    private boolean statusFlight = false;

    public Booking(int weight, City origin, City destination, Passenger passenger, ClassType classType, int id) {
        this.weight = weight;
        this.origin = origin;
        this.destination = destination;
        this.passenger = passenger;
        this.classType = classType;
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestination() {
        return destination;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public ClassType getClassType() {
        return classType;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return statusFlight;
    }

    public void setStatus(boolean status) {
        this.statusFlight = status;
    }
    
    
    
}

