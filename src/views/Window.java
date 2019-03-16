package views;
import javax.swing.JOptionPane;
import controllers.CategoryPerson;
import java.util.Calendar;
import java.util.GregorianCalendar;
import models.City;
import models.ClassType;
import controllers.GeneralOptions;
import controllers.ActionPassenger;
import controllers.ActionPilot;
import controllers.ActionBooking;
import controllers.CategoryPlane;
import controllers.ActionPlane;
import controllers.ActionFlight;



public class Window {

    public ActionPilot getActionPilot(){
        return ActionPilot.valueOf(JOptionPane.showInputDialog(null,"Select the operation for pilot","Aeroline", 
                JOptionPane.INFORMATION_MESSAGE,null,ActionPilot.values(),ActionPilot.values()[0]).toString());    
    }
    
    public int CategoryPlane(){
        int op2 = JOptionPane.showOptionDialog(null, "Select the category of plane", "Airline - Person", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,CategoryPlane.values(),CategoryPlane.values()[0]);
        return op2;
    }
    
    public int ActionPlane(){
        int op2 = JOptionPane.showOptionDialog(null, "Select the action for plane", "Airline - Person", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,ActionPlane.values(),ActionPlane.values()[0]);
        return op2;
    }
    public int ActionFlight(){
        int op2 = JOptionPane.showOptionDialog(null, "Select the action for plane", "Airline - Person", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,ActionFlight.values(),ActionFlight.values()[0]);
        return op2;
    }
    
    public ActionBooking getActionBooking(){
        return ActionBooking.valueOf(JOptionPane.showInputDialog(null,"Select the operation for booking","Aeroline", 
                JOptionPane.INFORMATION_MESSAGE,null,ActionBooking.values(),ActionBooking.values()[0]).toString());    
    }
    
    public ActionPassenger getActionPassenger(){
        return ActionPassenger.valueOf(JOptionPane.showInputDialog(null,"Select the operation for passenger","Aeroline", 
                JOptionPane.INFORMATION_MESSAGE,null,ActionPassenger.values(),ActionPassenger.values()[0]).toString());    
    }
   
    public int getGeneralActionsButton (){
        int op1 = JOptionPane.showOptionDialog(null, "Select the operation", "Airline", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,GeneralOptions.values(), GeneralOptions.values()[0]);
        return op1;
    }
    
    public int getActionPerson (){
        int op2 = JOptionPane.showOptionDialog(null, "Select the category of person", "Airline - Person", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,CategoryPerson.values(),CategoryPerson.values()[0]);
        return op2;
    }
         
    public City getCity(String message){
        return City.valueOf(JOptionPane.showInputDialog(null,message,"Aeroline ", 
                JOptionPane.INFORMATION_MESSAGE,null,City.values(),City.values()[0]).toString());    
    }
  
    public int askForId (String tipe){
       
      int result =  Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the id number of the " + tipe ,"Number",JOptionPane.QUESTION_MESSAGE));
      
      return result;
    }
    
    public String askForName (){
        return (JOptionPane.showInputDialog(null, "Enter the name","Number",JOptionPane.QUESTION_MESSAGE));
    }
    
    public int askForNumber (String message){
        return Integer.parseInt(JOptionPane.showInputDialog(null, message,"Number",JOptionPane.QUESTION_MESSAGE));
    }
    
    public Calendar askDate (){
    
        String date =(JOptionPane.showInputDialog(null, "Enter the date with the format: (day/month/year) ex 09/12/1997","Number",JOptionPane.QUESTION_MESSAGE));
        String[] formatDay = date.split("/");
        int day = Integer.parseInt(formatDay[0]);
        int month = Integer.parseInt(formatDay[1]);
        int year = Integer.parseInt(formatDay[2]); 
        Calendar birthdate = new GregorianCalendar(year, month, day);
        return birthdate;
    }
    
    public boolean CheckDateIsValid (String date){
        boolean DateIsValid = false;      
        if (date.charAt(2)=='/'&& date.charAt(5) =='/'){
           DateIsValid = true;
        }
        if (date.length()== 10){
           DateIsValid = true;
        }
        return DateIsValid;
    }
   
    public void showMessage (String message){
        JOptionPane.showMessageDialog(null, message,"RESULT",JOptionPane.INFORMATION_MESSAGE);
    }
     
}
