package controllers;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Window;
import models.AirLine;
import models.City;
import models.ClassType;
import models.ErrorTheBaseDataIsFulls;
import models.ErroridNotFound;
import models.AirPlane;
import models.ErrorNoCity;
import models.ErrorNoPlanes;
import models.ErrorVeryOldPilot;

public class Controller {
    
    private Window window;
    private AirLine aeroline;
    private boolean running;
    private static final String ERROR_ID_IN_USE = "¡Error!: The id already in use, please check and try again." ;
    private static final String ERROR_ID_NOT_EXIST = "¡Error!: The id not exist, please check and try again." ;
    private static final String MEMORY_FULL = "¡Error!: The memory space this full." ;

    public Controller() throws ErroridNotFound, ErrorTheBaseDataIsFulls, ErrorVeryOldPilot, ErrorNoCity{
        window = new Window();
        aeroline = new AirLine();
        running = true;
        aeroline.registerPassenger(aeroline.createPassenger(1, "Juan", new GregorianCalendar(1997,4,4)));
        aeroline.registerPassenger(aeroline.createPassenger(2, "Maria", new GregorianCalendar(1993,11,21)));
        aeroline.registerPassenger(aeroline.createPassenger(3, "Carlos", new GregorianCalendar(1981,4,4)));
        aeroline.registerPassenger(aeroline.createPassenger(4, "Andrea", new GregorianCalendar(1990,3,5)));
        aeroline.registerPassenger(aeroline.createPassenger(5, "Esteban", new GregorianCalendar(1971,10,11)));
        aeroline.registerPilot(aeroline.createPilot(1, "Jorge", new GregorianCalendar(1987,12,4), City.LIMA));
        aeroline.registerPilot(aeroline.createPilot(2, "David", new GregorianCalendar(1991,8,18), City.BOGOTÁ));
        aeroline.registerPilot(aeroline.createPilot(3, "Marta", new GregorianCalendar(1994,1,13), City.BUENOS_AIRES));
        aeroline.registerPilot(aeroline.createPilot(4, "Carlos", new GregorianCalendar(1989,3,18), City.BOGOTÁ));
        aeroline.registerPilot(aeroline.createPilot(5, "Sandra", new GregorianCalendar(1980,2,9), City.MEXICO_DF));
        aeroline.registerBooking(aeroline.creaatebooking(1300, City.BOGOTÁ, City.QUITO, 2, ClassType.FIRST_CLASS, 1));
        aeroline.registerBooking(aeroline.creaatebooking(1220, City.BOGOTÁ, City.QUITO, 4, ClassType.FIRST_CLASS, 5));
        aeroline.registerBooking(aeroline.creaatebooking(1220, City.BRASILIA, City.MEXICO_DF, 4, ClassType.FIRST_CLASS, 6));
        aeroline.registerBooking(aeroline.creaatebooking(32, City.BOGOTÁ, City.QUITO, 1, ClassType.FIRST_CLASS, 3));
        aeroline.registerBooking(aeroline.creaatebooking(1220, City.LIMA, City.CARACAS, 4, ClassType.FIRST_CLASS, 7));
        aeroline.registerBooking(aeroline.creaatebooking(40, City.BOGOTÁ, City.QUITO, 2, ClassType.FIRST_CLASS, 2));
        aeroline.registerBooking(aeroline.creaatebooking(1220, City.BRASILIA, City.MEXICO_DF, 4, ClassType.FIRST_CLASS, 8));
        aeroline.registerBooking(aeroline.creaatebooking(1220, City.CARACAS, City.QUITO, 4, ClassType.FIRST_CLASS, 9));
        aeroline.registerBooking(aeroline.creaatebooking(1220, City.LIMA, City.BUENOS_AIRES, 4, ClassType.FIRST_CLASS, 10));
        aeroline.registerBooking(aeroline.creaatebooking(450, City.BOGOTÁ, City.QUITO, 3, ClassType.FIRST_CLASS, 4));

          
        
        AirPlane airPlaneOne =(aeroline.createPlaneRegular(1, 27, 129));
        AirPlane airPlaneTwo =(aeroline.createPlaneRegular(2, 30, 140));
        AirPlane airPlaneThree =(aeroline.createPlaneJumbo(3, 80, 189));
        AirPlane airPlaneFour =(aeroline.createPlaneJumbo(4, 100, 222));
        AirPlane airPlaneFive =(aeroline.createPlanePrivate(5, 200, 320));
        
        airPlaneOne.setCategoryPlane(CategoryPlane.REGULAR);
        airPlaneTwo.setCategoryPlane(CategoryPlane.REGULAR);
        airPlaneThree.setCategoryPlane(CategoryPlane.JUMBO);
        airPlaneFour.setCategoryPlane(CategoryPlane.JUMBO);
        airPlaneFive.setCategoryPlane(CategoryPlane.PRIVATE);
        
        aeroline.registerPlane(airPlaneOne);
        aeroline.registerPlane(airPlaneTwo);
        aeroline.registerPlane(airPlaneThree);
        aeroline.registerPlane(airPlaneFour);
        aeroline.registerPlane(airPlaneFive);
           
        aeroline.deletePassenger(2);
        aeroline.deletePilot(2);
        aeroline.deleteBooking(2);
        controlGeneralActions();
    }

    public void controlGeneralActions(){
        while (running){
            switch (window.getGeneralActionsButton()){
                case 0:
                Person();
                break;
                case 1:
                plane();
                break;
                case 2:
                booking();
                break;
                case 3:
                flight();
                break;
                case 4:
                running=false;    
            }
        }
    }

//_______________________GENERAL__ACTIONS______________________________________________________________________________________________       
  
    public void Person() {
        boolean runningPerson = true;
        while (runningPerson){
             switch (window.getActionPerson()){
                case 0:
                pilot();
                break;
                case 1:
                passenger();
                break; 
                case 2:
                runningPerson = false;
                break;   
            }
        }
    }
   
    private void flight() {
        switch (window.ActionFlight()){
            case 0:
                generateFlights();
                break;
            case 1:
                showFlights();
                break;
            case 2:
                showListBooking();
                break;
            case 3:
                findBooking();
        }
    }
    
    public void booking(){ 
       switch (window.getActionBooking()){
            case REGISTER_BOOKING:
                registerBooking();
                break;
            case DELETE_BOOKING:
                deleteBooking();
                break;
            case SHOW_LIST_BOOKING:
                showListBooking();
                break;
            case FIND_BOOKING:
                findBooking();
        }
    }
    
    public void plane(){   
        boolean runningPlane = true;
        while (runningPlane){ 
            switch (window.ActionPlane()){
                case 0:
                    registerPlane();
                    break;
                case 1:
                    deletePlane();
                    break;
                case 2:
                    showPlane();
                    break;
                case 3:
                    findPlane();
                    break;
                case 4:
                    runningPlane = false;
            }
        }
    }
//_______________________PERSON______________________________________________________________________________________________   
   
  public void passenger() {
        switch (window.getActionPassenger()){
            case REGISTER_PASSENGER:
                registerPassenger();
                break;
            case DELETE_PASSENGER:
                deletePassenger();
                break;
            case SHOW_LIST_PASSENGER:
                showListPassenger();
                break;
            case FIND_PASSENGER:
                findPassenger();
            
        }
    }  
  
  public void pilot() {
        switch (window.getActionPilot()){
            case REGISTER_PILOT:
                registerPilot();
                break;
            case DELETE_PILOT:
                deletePilot();
                break;
            case SHOW_LIST_PILOT:
                showListPilot();
                break;
            case FIND_PILOT:
                findPilot();
        }
    }  
  
//_______________________Methods______________________________________________________________________________________________          
     
    public void registerPlane() {
        int c = window.CategoryPlane();
        int id = window.askForId("plane");
        int maxCapacity = window.askForNumber("Enter the max capacity of the plane");
        int fuelLevel = window.askForNumber("Enter the fuel level of the plane");

        switch (c){
            case 0:
             AirPlane airPlane = aeroline.createPlanePrivate(id, maxCapacity, fuelLevel);
                try {  
                   
                    aeroline.registerPlane(airPlane);
                    airPlane.setCategoryPlane(CategoryPlane.PRIVATE);
                } catch (ErrorTheBaseDataIsFulls ex) {
                    window.showMessage(MEMORY_FULL);
                    return;
                }catch (ErroridNotFound ex) {
                    window.showMessage(ERROR_ID_IN_USE );
                    return;
                }
                window.showMessage(" Plane type private added to de system with the id " + id);  
                
                break;
                    
            case 1:
                 AirPlane airPlanes = aeroline.createPlaneRegular(id, maxCapacity, fuelLevel);
                try {
                   
                    aeroline.registerPlane(airPlanes);
                    airPlanes.setCategoryPlane(CategoryPlane.REGULAR);
                    aeroline.registerPlane(aeroline.createPlaneRegular(id, maxCapacity, fuelLevel));
                } catch (ErrorTheBaseDataIsFulls ex) {
                    window.showMessage(MEMORY_FULL);
                    return;
                }catch (ErroridNotFound ex) {
                    window.showMessage(ERROR_ID_IN_USE);
                    return;
                }
                window.showMessage(" Plane type regular added to de system with the id " + id);    
                break;
            case 2:
                 AirPlane airPlaness = aeroline.createPlaneJumbo(id, maxCapacity, fuelLevel);
                try {
                   
                    aeroline.registerPlane(airPlaness);
                    airPlaness.setCategoryPlane(CategoryPlane.JUMBO);
                } catch (ErrorTheBaseDataIsFulls ex) {
                    window.showMessage(MEMORY_FULL);
                   return;
                }catch (ErroridNotFound ex) {
                     window.showMessage(ERROR_ID_IN_USE );
                   return;
                }
                window.showMessage(" Plane type jumbo added to de system with the id " + id);    
                break;
        }
    }  
    
    private void registerPassenger(){
        int id = window.askForId("Passenger");
        String name = window.askForName();
        Calendar birthDate = window.askDate();
       try {
             aeroline.registerPassenger(aeroline.createPassenger(id, name, birthDate));
        } catch (ErrorTheBaseDataIsFulls ex) {
             window.showMessage(MEMORY_FULL);
           return;
        }catch (ErroridNotFound ex) {
             window.showMessage(ERROR_ID_IN_USE );
           return;
        }
       
        window.showMessage(" Passenger " + name + " added to the system with the id: " +id);    
    }
    
    private void registerPilot(){
        int id = window.askForId("Pilot");
        String name = window.askForName();
        Calendar birthDate = window.askDate();
        City city = window.getCity("Enter the city where the pilot lives now "+name);
            try {
                aeroline.registerPilot(aeroline.createPilot(id, name, birthDate,city ));
            } catch (ErrorVeryOldPilot ex) {
                window.showMessage("Sorry, pilot very old");
                
            } catch (ErrorTheBaseDataIsFulls ex) {
                window.showMessage(MEMORY_FULL);
            return;
            }catch (ErroridNotFound ex) {
            window.showMessage(ERROR_ID_IN_USE );
            return;
        }
        window.showMessage(" Pilot " + name + " added to the system with the id: " +id);    
    }
    
    private void registerBooking(){
        int id = window.askForId("booking");
        int idPassenger = window.askForId("of the passenger");
        int weight = window.askForNumber("Enter the weight of the luggage (kg)");
        City origin = window.getCity("Enter the city of origin of the flight");
        City destination = window.getCity("Enter the destination city");
      
        try {
             aeroline.registerBooking(aeroline.creaatebooking(weight, origin, destination, idPassenger, ClassType.FIRST_CLASS, id));
        } catch (ErrorTheBaseDataIsFulls ex) {
             window.showMessage(MEMORY_FULL);
           return;
        }catch (ErroridNotFound ex) {
             window.showMessage(ERROR_ID_NOT_EXIST );
           return;
        }
        window.showMessage(" Booking with origin in " + origin + ", destination to " + destination+ ", passenger number "+idPassenger+"added tho the system");    
    }
//_________________
    private void showListPassenger() {
         String list = aeroline.showPassengersRegistered();
         window.showMessage(list);
    }
   
    private void showListBooking() {
         String list = aeroline.showBookingRegistered();
         window.showMessage(list);
    }
    
    private void showListPilot() {
        String list = aeroline.showPilotsRegistered();
         window.showMessage(list);
    }
    
    public void showPlane() {
        String list = aeroline.showPlanesRegistered();
         window.showMessage(list);   
    }  
    
    private void showFlights() {
        String list = aeroline.showFlightsGenerated();
         window.showMessage(list);   
    }

//_________________
    private void deletePassenger() {
        try {
            aeroline.deletePassenger(window.askForId("Passenger for delete"));
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST);
        }
        window.showMessage("Passenger delete");
    }

    private void deletePilot() {
      try {
            aeroline.deletePassenger(window.askForId("Pilot for delete"));
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST );
        }
      window.showMessage("Pilot delete");
    }
  
    private void deleteBooking() {
        try {
            aeroline.deleteBooking(window.askForId("booking for delete"));
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST );
        }
      window.showMessage("Booking delete");
    }
    
    public void deletePlane() {
        try {
            aeroline.deletePlane(window.askForId("plane for delete"));
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST );
        }
      window.showMessage("Plane delete");
    }
    
//_________________   
    
    private void findPilot() {
        try {
          window.showMessage(aeroline.showPilotForId(window.askForId("pilot for find")));
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST);
        }
    }

    private void findPassenger() {
        try {
          window.showMessage(aeroline.showPassengerForId(window.askForId("passenger for find")));
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST);
        }
    } 
    
    private void findBooking() {
        try {
          window.showMessage(aeroline.showBookingForId(window.askForId("bookig for find")));
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST);
        }
    }   
    
    public void findPlane() {
        try {
          window.showMessage(aeroline.showPlaneForId(window.askForId("plane for find")));
          
        } catch (ErroridNotFound ex) {
              window.showMessage(ERROR_ID_NOT_EXIST);
        }
       
    }  

//___________________ 
   
    private void generateFlights() {
        try {
            aeroline.generateFlights();
        } catch (ErrorNoCity ex) {
           window.showMessage("No booking destinations in common, try again later");
        } catch (ErrorNoPlanes ex) {
           window.showMessage("No airplnaes or passengers enough to generate flights, try again later");
        } catch (ErrorTheBaseDataIsFulls ex) {
           window.showMessage(MEMORY_FULL);
        }
    }

   
    
    
}
   

