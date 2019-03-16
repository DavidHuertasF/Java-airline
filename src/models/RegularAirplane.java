package models;

public class RegularAirplane extends AirPlane implements FlyManager{
   private static final int MAX_FLY_HOURS = 1000;
   private static final int WAREHOUSE_LIMIT = 5000;
   private double  DIST_COST;

    public RegularAirplane(int id, int maxCapoacity, int fuelLevel) {
        super(id, maxCapoacity, fuelLevel);
       
        firstClassSeats = ((maxCapacity*20)/100);
        executiveSeats = ((maxCapacity*30)/100);
        touristSeats = ((maxCapacity*50)/100);
    }

    @Override
    public void distribuiteSeats() {
        firstClassSeats = ((maxCapacity*20)/100);
        executiveSeats = ((maxCapacity*30)/100);
        touristSeats = ((maxCapacity*50)/100);
    }

    @Override
    public boolean checkStae() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

