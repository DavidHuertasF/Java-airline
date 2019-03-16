package models;
import java.util.Calendar;

public class Passenger extends Person{
    private int kmNumber;
    
   public Passenger(int id,String name,Calendar birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    } 

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }
   
}
