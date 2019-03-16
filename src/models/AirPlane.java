package models;
import controllers.CategoryPlane;
public class AirPlane {
    int  maxCapacity;
    int fuelLevel;  
    int flyHours;
    int firstClassSeats;
    int executiveSeats;
    int touristSeats;
    int id;
    CategoryPlane categoryPlane;
    

    public AirPlane(int id, int maxCapoacity, int fuelLevel) {
        this.id = id;
        this.maxCapacity = maxCapoacity;
        this.fuelLevel = fuelLevel;
       
    }

    public void setFlyHours(int flyHours) {
        this.flyHours = flyHours;
    }

    public CategoryPlane getCategoryPlane() {
        return categoryPlane;
    }

    public void setCategoryPlane(CategoryPlane categoryPlane) {
        this.categoryPlane = categoryPlane;
    }

    
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public int getFlyHours() {
        return flyHours;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public int getExecutiveSeats() {
        return executiveSeats;
    }

    public int getTouristSeats() {
        return touristSeats;
    }

    public int getId() {
        return id;
    }
    
    
    
    
}
