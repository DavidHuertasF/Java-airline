package models;

   public class PrivateAirplane extends AirPlane implements FlyManager{
   private static final int MAX_FLY_HOURS = 500;
   private static final int WAREHOUSE_LIMIT = 0;
   private double  DIST_COST;

    public PrivateAirplane(int id, int maxCapoacity, int fuelLevel) {
        super(id, maxCapoacity, fuelLevel);
       
      firstClassSeats = maxCapacity;
       touristSeats = 0;
       executiveSeats = 0;
    }
   
    
   public boolean checkChildren(Passenger passenger){
       return true;
   }

    @Override
    public void distribuiteSeats() {
       firstClassSeats = maxCapacity;
       touristSeats = 0;
       executiveSeats = 0;
    }

    @Override
    public boolean checkStae() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

