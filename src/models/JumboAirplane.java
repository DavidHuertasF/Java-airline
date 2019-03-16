package models;

public class JumboAirplane extends AirPlane implements FlyManager{
   private static final int MAX_FLY_HOURS = 5000;
   private static final int WAREHOUSE_LIMIT = 30000;
   private double  DIST_COST;
  
 public JumboAirplane(int id, int maxCapoacity, int fuelLevel) {
        super(id, maxCapoacity, fuelLevel);
        
        firstClassSeats = ((maxCapacity*10)/100);
        executiveSeats = ((maxCapacity*20)/100);
        touristSeats = ((maxCapacity*70)/100);
    }

    @Override
    public void distribuiteSeats() {
        firstClassSeats = ((maxCapacity*10)/100);
        executiveSeats = ((maxCapacity*20)/100);
        touristSeats = ((maxCapacity*70)/100);
    }

    @Override
    public boolean checkStae() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   



}

