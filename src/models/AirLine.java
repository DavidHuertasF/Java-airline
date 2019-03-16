package models;
import controllers.CategoryPlane;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;


import java.util.Random;
public class AirLine {
    private Pilot[]    pilotsRegisteredList;
    private Flight[]   FlightsRegisteredList;
    private Booking[]  bookingsRegisteredList;
    private Passenger[]passengerRegisteredList;
    private AirPlane[] airPlaneRegisteredList;
    private int idFlight;
    Random aleatorio = new Random();
 
    public AirLine(){     
        pilotsRegisteredList = new Pilot [20];
        FlightsRegisteredList = new Flight [20];
        bookingsRegisteredList = new Booking[20];
        passengerRegisteredList =new Passenger[20];
        airPlaneRegisteredList = new AirPlane[20];
        
    }
 
//________________________VERIFY_______________________________________________________________________________________________
    
    public boolean verifyIdPassengerIsNotInUse (Passenger passenger){
        boolean IdIsInUse = false;      
        for (int i = 0; i < passengerRegisteredList.length; i++){
           if ( passengerRegisteredList[i] != null ){
                if (passenger.getId() == (passengerRegisteredList[i].getId())){
                    IdIsInUse = true;
                }
            }
        }
        return IdIsInUse;
    }
   
    public boolean verifyIdPilotIsNotInUse (Pilot pilot){
        boolean IdIsInUse = false;      
        for (int i = 0; i < pilotsRegisteredList.length; i++){
           if ( pilotsRegisteredList[i] != null ){
                if (pilot.getId() == (pilotsRegisteredList[i].getId())){
                    IdIsInUse = true;
                }
            }
        }
        return IdIsInUse;
    }
   
    public boolean verifyIdBookingIsNotInUse (Booking booking){
        boolean IdIsInUse = false;      
        for (int i = 0; i < bookingsRegisteredList.length; i++){
           if ( bookingsRegisteredList[i] != null ){
                if (booking.getId()== (bookingsRegisteredList[i].getId())){
                    IdIsInUse = true;
                }
            }
        }
        return IdIsInUse;
    }
   
    public boolean verifyIdPlaneIsNotInUse (AirPlane airplane){
        boolean IdIsInUse = false;      
        for (int i = 0; i < airPlaneRegisteredList.length; i++){
           if ( airPlaneRegisteredList[i] != null ){
                if (airplane.getId()== (airPlaneRegisteredList[i].getId())){
                    IdIsInUse = true;
                }
            }
        }
        return IdIsInUse;
    }
   
//________________________CREATE_______________________________________________________________________________________________
    
    public AirPlane createPlaneJumbo (int id,int maxCapacity,int fuelLevel){
        return new JumboAirplane(id,maxCapacity, fuelLevel);   
    }
   
    public AirPlane createPlanePrivate (int id,int maxCapacity,int fuelLevel){
        return new PrivateAirplane(id,maxCapacity, fuelLevel);   
    }
   
    public AirPlane createPlaneRegular (int id,int maxCapacity,int fuelLevel){
        return new RegularAirplane(id,maxCapacity, fuelLevel);   
    }
   
    public  Passenger createPassenger (int id, String name, Calendar birthDate){
       return new Passenger(id, name, birthDate);
    }
   
    public  Pilot createPilot (int id,String name,Calendar birthDate,City city){
      return new Pilot(id, name, birthDate, city);
    }
    
    public Booking creaatebooking (int weight, City origin, City destination, int idPassenger, ClassType classType, int id) throws ErroridNotFound{
        return new Booking(weight, origin, destination, findPassengerById(idPassenger), classType, id);
    }
    public  Flight createFlight(int id, City origin,City destination,int arrivalTime,int departureTime, AirPlane airPlane){
      return new Flight(id, destination, origin, arrivalTime, departureTime,airPlane);
    }
//____________________________REGISTER___________________________________________________________________________________________ 

    public void registerPassenger( Passenger passenger) throws ErroridNotFound, ErrorTheBaseDataIsFulls{
     
        boolean IdIsInUse = verifyIdPassengerIsNotInUse(passenger);
        if (IdIsInUse == true){
             throw new ErroridNotFound();      
        }
        for (int i = 0; i < passengerRegisteredList.length; i++){
            if (passengerRegisteredList[i]== null ){
                passengerRegisteredList[i]= passenger;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFulls(); 
    }  
   
    public void registerPilot(Pilot pilot) throws ErroridNotFound, ErrorTheBaseDataIsFulls, ErrorVeryOldPilot{
         boolean IdIsInUse = verifyIdPilotIsNotInUse(pilot);
       
         if (CalculateAge(pilot.getBirthDate()) > 50){
             throw new  ErrorVeryOldPilot();
         }
         
         if (IdIsInUse == true){
             throw new ErroridNotFound();      
        }
        for (int i = 0; i < pilotsRegisteredList.length; i++){
            if (pilotsRegisteredList[i]== null ){
                pilotsRegisteredList[i]= pilot;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFulls(); 
    }  
    
    public void registerBooking(Booking booking)throws ErroridNotFound, ErrorTheBaseDataIsFulls{
         boolean IdIsInUse = verifyIdBookingIsNotInUse(booking);
        if (IdIsInUse == true){
             throw new ErroridNotFound();      
        }
        for (int i = 0; i < bookingsRegisteredList.length; i++){
            if (bookingsRegisteredList[i]== null ){
                bookingsRegisteredList[i]= booking;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFulls(); 
    }
    
    public void registerPlane(AirPlane airPlane)throws ErroridNotFound, ErrorTheBaseDataIsFulls{
         boolean IdIsInUse = verifyIdPlaneIsNotInUse(airPlane);
        if (IdIsInUse == true){
             throw new ErroridNotFound();      
        }
        for (int i = 0; i < airPlaneRegisteredList.length; i++){
            if (airPlaneRegisteredList[i]== null ){
                airPlaneRegisteredList[i]= airPlane;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFulls(); 
    }
     public void registerFlight(Flight flight) throws ErrorTheBaseDataIsFulls{
        for (int i = 0; i < FlightsRegisteredList.length; i++){
            if (FlightsRegisteredList[i]== null ){
                FlightsRegisteredList[i]= flight;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFulls(); 
    }
     
 //_________________________FIND FOR ID___________________________________________________________________________________________    

    public  Passenger findPassengerById (int id)throws ErroridNotFound{     
        for (int i = 0; i < passengerRegisteredList.length; i++){
            if (passengerRegisteredList[i] != null) {
                 if (passengerRegisteredList[i].getId()==(id)){ 
                    return passengerRegisteredList[i];
                }
            }
        }          
        throw new ErroridNotFound();     
    }
    
    public  Pilot findPilotById (int id)throws ErroridNotFound{     
        for (int i = 0; i < pilotsRegisteredList.length; i++){
            if (pilotsRegisteredList[i] != null) {
                 if (pilotsRegisteredList[i].getId()==(id)){ 
                    return pilotsRegisteredList[i];
                }
            }
        }          
        throw new ErroridNotFound();     
    }
    
    public  Booking findBookingById (int id)throws ErroridNotFound{     
        for (int i = 0; i < bookingsRegisteredList.length; i++){
            if (bookingsRegisteredList[i] != null) {
                 if (bookingsRegisteredList[i].getId()==(id)){ 
                    return bookingsRegisteredList[i];
                }
            }
        }          
        throw new ErroridNotFound();     
    }
    
    public  AirPlane findAirPlaneById (int id)throws ErroridNotFound{     
        for (int i = 0; i < airPlaneRegisteredList.length; i++){
            if (airPlaneRegisteredList[i] != null) {
                 if (airPlaneRegisteredList[i].getId()==(id)){ 
                    return airPlaneRegisteredList[i];
                }
            }
        }          
        throw new ErroridNotFound();     
    }
//________________________SHOW__LIST_____________________________________________________________________________________________    
    
    public String  showPassengersRegistered(){
        String PassengersRegistered = "";
        for (int i = 0; i < passengerRegisteredList.length; i++){
            
            if (passengerRegisteredList[i] != null ){
                PassengersRegistered += (" "+passengerRegisteredList[i].getName()+"      "+ passengerRegisteredList[i].getId()+"  age:"+CalculateAge(passengerRegisteredList[i].getBirthDate())+"\n") ;   
            }
        }   
        return PassengersRegistered;
    }
   
    public String  showPilotsRegistered(){
        String PilotsRegistered = "";
        for (int i = 0; i < pilotsRegisteredList.length; i++){
          
            if (pilotsRegisteredList[i] != null ){
                 PilotsRegistered += (" "+pilotsRegisteredList[i].getName()+pilotsRegisteredList[i].getId()+"  age:"+CalculateAge(passengerRegisteredList[i].getBirthDate())+"\n") ;    
            }
        }   
        return PilotsRegistered;
    }
    
    public String  showBookingRegistered(){
        String BookingsRegistered = "";
        for (int i = 0; i < bookingsRegisteredList.length; i++){
            if (bookingsRegisteredList[i] != null ){
                 BookingsRegistered += ("id: "+bookingsRegisteredList[i].getId()+"  Weight: "+bookingsRegisteredList[i].getWeight()+ "    STATUS: "+bookingsRegisteredList[i].isStatus()+
                         "\n"+"Origin: "+bookingsRegisteredList[i].getOrigin()+"  Destination: "+bookingsRegisteredList[i].getDestination()+
                         "\n"+"Passenger: "+bookingsRegisteredList[i].getPassenger().getName()+"  Class type: "+bookingsRegisteredList[i].getClassType()+"\n"+"\n") ;
            }
        }   
        return BookingsRegistered;
    }
    
    public String  showPlanesRegistered(){
        String PlanesRegistered = "";
        for (int i = 0; i < airPlaneRegisteredList.length; i++){
            
            if (airPlaneRegisteredList[i] != null ){
                PlanesRegistered += ("Airplane number: " + airPlaneRegisteredList[i].getId()+"   Type: "+ airPlaneRegisteredList[i].getCategoryPlane()+"  Capacity:  "+ airPlaneRegisteredList[i].getMaxCapacity()+"persons" +"  FLY HOURS:  "+ airPlaneRegisteredList[i].getFlyHours()+"\n"+
                               "Distribution of seats  "+ " FirstClass: "+airPlaneRegisteredList[i].getFirstClassSeats()+" ExecutiveClass: "+airPlaneRegisteredList[i].getExecutiveSeats()+ " TouristClass: "+airPlaneRegisteredList[i].getTouristSeats()+"\n"+"\n") ;   
            }
        }   
        return PlanesRegistered;
    }
    
    public String  showFlightsGenerated(){
        String PlanesRegistered = "";
        for (int i = 0; i < FlightsRegisteredList.length; i++){
            
            if (FlightsRegisteredList[i] != null ){
                PlanesRegistered += ("Flight number: " + FlightsRegisteredList[i].getId()+"   Origin: "+ FlightsRegisteredList[i].getOrigin()+"  Destination:  "+ FlightsRegisteredList[i].getDestination()+"\n");
            }    
        }
        return PlanesRegistered;
    }

//___________________DELETE____________________________________________________________________________________________________    

    public void deletePassenger(int id) throws ErroridNotFound{
        Passenger passenger = findPassengerById(id);
        for (int i = 0 ; i < passengerRegisteredList.length;i++){
            if (passengerRegisteredList[i] != null) {  
                if (passengerRegisteredList[i].equals(passenger) ){
                    passengerRegisteredList[i]= null;               
                }
            }
        }  
    }
   
    public void deletePilot(int id) throws ErroridNotFound{
        Pilot pilot = findPilotById(id);
        for (int i = 0 ; i < pilotsRegisteredList.length;i++){
            if (pilotsRegisteredList[i] != null) {  
                if (pilotsRegisteredList[i].equals(pilot) ){
                    pilotsRegisteredList[i]= null;               
                }
            }
        }
    }    
    
    public void deleteBooking(int id) throws ErroridNotFound{
        Booking booking = findBookingById(id);
        for (int i = 0 ; i < bookingsRegisteredList.length;i++){
            if (bookingsRegisteredList[i] != null) {  
                if (bookingsRegisteredList[i].equals(booking) ){
                    bookingsRegisteredList[i]= null;               
                }
            }
        }      
    }
    
    public void deletePlane(int id) throws ErroridNotFound{
        AirPlane plane = findAirPlaneById(id);
        for (int i = 0 ; i < airPlaneRegisteredList.length;i++){
            if (airPlaneRegisteredList[i] != null) {  
                if (airPlaneRegisteredList[i].equals(plane) ){
                    airPlaneRegisteredList[i]= null;               
                }
            }
        }  
    }

//___________________SHOW_FOR_ID____________________________________________________________________________________________________

    public String  showPassengerForId(int id) throws ErroridNotFound{
      Passenger passenger = findPassengerById(id);
        return ("Passenger  --> "+passenger.getName()+"   id:"+passenger.getId()+"  age:"+CalculateAge(passenger.getBirthDate())) ;    
    }
    
    public String  showPilotForId(int id) throws ErroridNotFound{
      Pilot pilot = findPilotById(id);
        return ("P  --> "+pilot.getName()+"   id:"+pilot.getId()+"  age:"+CalculateAge(pilot.getBirthDate())) ;    
    }
    
    public String  showBookingForId(int id) throws ErroridNotFound{
      Booking booking = findBookingById(id);
        return ("Booking  --> Id:"+booking.getId()+"   Origin:"+booking.getOrigin()+"  Destination :"+booking.getDestination()+"  Class Type:"+booking.getClassType()+"\n"+
                "   Passenger:"+ booking.getPassenger().getName()+ "   Weight:"+booking.getWeight()) ;    
    }

    public String  showPlaneForId(int id) throws ErroridNotFound{
        AirPlane airPlane = findAirPlaneById(id);
        return ("AirPlane number:  "+ airPlane.getId()) ;    
    }
    
    
//_________________________GENERATE_FLIGHTS__________________________________________________________________________________________

    public int CalculateAge(Calendar birthDate){
        
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String actualDate = formato.format(fechaActual);
        int year = birthDate.get(1);
        int month = birthDate.get(2);
        int day = birthDate.get(3);
        String[] dat2 = actualDate.split("/");
        int years = Integer.parseInt(dat2[0]) - year;
        int mes = Integer.parseInt(dat2[1]) - month;
        if (mes < 0) {
            years = years - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[2]) - day;
            if (dia > 0) {
                years = years - 1;
            }
        }
        return years;
    }
    
    public City CityMostPopular (String type) throws ErrorNoCity{
      int conBrasil = 0;
      int conPeru = 0;
      int conColombia = 0;
      int conVenezuela = 0;
      int conMexico = 0;
      int conArgentina = 0;
      int contEcuador = 0;
        
        if (type == "ORIGIN"){
            for (int i = 0; i < bookingsRegisteredList.length; i++){
                if (bookingsRegisteredList[i] != null ){
                    if (bookingsRegisteredList[i].getOrigin() == City.BOGOTÁ) {
                        conColombia ++;
                    }else if (bookingsRegisteredList[i].getOrigin() == City.BRASILIA){
                        conBrasil ++;   
                    }else if (bookingsRegisteredList[i].getOrigin() == City.BUENOS_AIRES){
                        conArgentina ++;   
                    }else if (bookingsRegisteredList[i].getOrigin() == City.CARACAS){
                        conVenezuela ++;   
                    }else if (bookingsRegisteredList[i].getOrigin() == City.LIMA){
                        conPeru ++;   
                    }else if (bookingsRegisteredList[i].getOrigin() == City.MEXICO_DF){
                        conMexico ++;   
                    }else if (bookingsRegisteredList[i].getOrigin() == City.QUITO){
                        contEcuador ++;   
                   }             
                } 
            }        
            if (conColombia>conArgentina && conColombia>conVenezuela && conColombia>conPeru && conColombia>conMexico && conColombia>contEcuador && conColombia>conBrasil ) {
                return City.BOGOTÁ;
            }else if (conBrasil>conArgentina && conBrasil>conVenezuela && conBrasil>conPeru && conBrasil>conMexico && conBrasil>contEcuador && conBrasil>conColombia){
                return City.BRASILIA;
            }else if (conArgentina>conBrasil && conArgentina>conVenezuela && conArgentina>conPeru && conArgentina>conMexico && conArgentina>contEcuador && conArgentina>conColombia){
                return City.BUENOS_AIRES; 
            }else if (conVenezuela>conBrasil && conVenezuela>conArgentina && conVenezuela>conPeru && conVenezuela>conMexico && conVenezuela>contEcuador && conVenezuela>conColombia){
                return City.CARACAS;  
            }else if (conPeru>conBrasil && conPeru>conArgentina && conPeru>conVenezuela && conPeru>conMexico && conPeru>contEcuador && conPeru>conColombia){
                return City.LIMA; 
            }else if (conMexico>conBrasil && conMexico>conArgentina && conMexico>conVenezuela && conMexico>conPeru && conMexico>contEcuador && conMexico>conColombia){
                return City.BRASILIA; 
            }else if (contEcuador>conBrasil && contEcuador>conArgentina && contEcuador>conVenezuela && contEcuador>conPeru && contEcuador>conMexico && contEcuador>conColombia){
                return City.QUITO;  
            }
        }
        else if (type == "DESTINATION"){
            for (int i = 0; i < bookingsRegisteredList.length; i++){
                if (bookingsRegisteredList[i] != null ){
                    if (bookingsRegisteredList[i].getDestination()== City.BOGOTÁ) {
                        conColombia ++;
                    }else if (bookingsRegisteredList[i].getDestination() == City.BRASILIA){
                        conBrasil ++;   
                    }else if (bookingsRegisteredList[i].getDestination() == City.BUENOS_AIRES){
                        conArgentina ++;   
                    }else if (bookingsRegisteredList[i].getDestination() == City.CARACAS){
                        conVenezuela ++;   
                    }else if (bookingsRegisteredList[i].getDestination() == City.LIMA){
                        conPeru ++;   
                    }else if (bookingsRegisteredList[i].getDestination() == City.MEXICO_DF){
                        conMexico ++;   
                    }else if (bookingsRegisteredList[i].getDestination() == City.QUITO){
                        contEcuador ++;   
                   }             
                } 
            }        
            if (conColombia>conArgentina && conColombia>conVenezuela && conColombia>conPeru && conColombia>conMexico && conColombia>contEcuador && conColombia>conBrasil ) {
                return City.BOGOTÁ;
            }else if (conBrasil>conArgentina && conBrasil>conVenezuela && conBrasil>conPeru && conBrasil>conMexico && conBrasil>contEcuador && conBrasil>conColombia){
                return City.BRASILIA;
            }else if (conArgentina>conBrasil && conArgentina>conVenezuela && conArgentina>conPeru && conArgentina>conMexico && conArgentina>contEcuador && conArgentina>conColombia){
                return City.BUENOS_AIRES; 
            }else if (conVenezuela>conBrasil && conVenezuela>conArgentina && conVenezuela>conPeru && conVenezuela>conMexico && conVenezuela>contEcuador && conVenezuela>conColombia){
                return City.CARACAS;  
            }else if (conPeru>conBrasil && conPeru>conArgentina && conPeru>conVenezuela && conPeru>conMexico && conPeru>contEcuador && conPeru>conColombia){
                return City.LIMA; 
            }else if (conMexico>conBrasil && conMexico>conArgentina && conMexico>conVenezuela && conMexico>conPeru && conMexico>contEcuador && conMexico>conColombia){
                return City.BRASILIA; 
            }else if (contEcuador>conBrasil && contEcuador>conArgentina && contEcuador>conVenezuela && contEcuador>conPeru && contEcuador>conMexico && contEcuador>conColombia){
                return City.QUITO;  
            }
        }
    throw new ErrorNoCity();
    } 
        
    public void generateFlights() throws ErrorNoCity, ErrorNoPlanes, ErrorTheBaseDataIsFulls{
        
        City origin = CityMostPopular("ORIGIN");
        City destination = CityMostPopular("DESTINATION");
        Booking[] bookingsRegisteredLists = new  Booking[10] ;
        int firstClass = 0;
        int executiveClass = 0;
        int touristClass = 0;
       
        for (int i = 0; i < bookingsRegisteredList.length; i++){
            System.out.println("x");
            if ( bookingsRegisteredList[i] != null ){
                if (bookingsRegisteredList[i].isStatus()== false){
                    if (origin == (bookingsRegisteredList[i].getOrigin())&& destination == (bookingsRegisteredList[i].getDestination())){
                       for (int k = 0; i < bookingsRegisteredLists.length; k++){
                            if (bookingsRegisteredLists[k] == null ){
                                bookingsRegisteredLists[k] = bookingsRegisteredList[i]; 
                                System.out.println(Arrays.toString(bookingsRegisteredLists));
                                bookingsRegisteredList[i].setStatus(true);
                                break; 
                            }   
                        }
                    }
                }
            }   
        }
        for (int l = 0; l < bookingsRegisteredLists.length; l++){
            if (bookingsRegisteredLists[l]!= null ){
                if (bookingsRegisteredLists[l].getClassType() == ClassType.FIRST_CLASS ){
                    firstClass ++;
                }   else if (bookingsRegisteredLists[l].getClassType() == ClassType.EXECUTIVE_CLASS ){
                    executiveClass ++;
                } else if (bookingsRegisteredLists[l].getClassType() == ClassType.TOURIST_CLASS ){
                   touristClass ++;
                } 
            }
        }   
        
        AirPlane airPlaneAsigned = assignAirPlaneForFlight(firstClass, touristClass, executiveClass);
        int numberaleatorio = (1+ aleatorio.nextInt(9));
        registerFlight(createFlight(idFlight, origin, destination, 10, numberaleatorio, airPlaneAsigned));
        idFlight ++;
        airPlaneAsigned.setFlyHours(airPlaneAsigned.getFlyHours() + (10-numberaleatorio));  
    }
       
    public AirPlane assignAirPlaneForFlight (int firstClass,int touristClass,int executiveClass  ) throws ErrorNoPlanes{
        AirPlane airPlaneAsigned = null;
      
         if (firstClass > 3 && touristClass == 0 && executiveClass == 0){
            for (int i = 0; i < airPlaneRegisteredList.length; i++){
                if ( airPlaneRegisteredList[i] != null ){
                    if (airPlaneRegisteredList[i].getCategoryPlane() == CategoryPlane.PRIVATE){
                            return  airPlaneRegisteredList[i];
                            
                    }
                }
            }     
        
        }else if (firstClass > 2 && touristClass > 6 && executiveClass >4){
             for (int i = 0; i < airPlaneRegisteredList.length; i++){
                if ( airPlaneRegisteredList[i] != null ){
                    if (airPlaneRegisteredList[i].getCategoryPlane() == CategoryPlane.JUMBO){
                            return  airPlaneRegisteredList[i];
                            
                    }
                }
            }   
        }else if (firstClass > 0 && touristClass > 2&& executiveClass >2){
             for (int i = 0; i < airPlaneRegisteredList.length; i++){
                if ( airPlaneRegisteredList[i] != null ){
                    if (airPlaneRegisteredList[i].getCategoryPlane() == CategoryPlane.REGULAR){
                            return airPlaneRegisteredList[i];
                            
                    }
                }
            }   
        }
        throw  new ErrorNoPlanes();
    }

    
}
    
    
    
    
    
    
    
    
    
    
    



   
 