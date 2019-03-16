package models;

import java.util.Calendar;

public class Pilot extends Person{
    private City city;
    private static final int MAX_AGE = 50;
    
    public Pilot(int id,String name,Calendar birthDate,City city) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.city = city;
    }
    
    public boolean checkMaxAge(){
        return true;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }
  
}
