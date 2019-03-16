
package run;
import javax.swing.JOptionPane;
import controllers.Controller;
import models.ErrorNoCity;
import models.ErrorTheBaseDataIsFulls;
import models.ErrorVeryOldPilot;
import models.ErroridNotFound;
public class Run {
    public static void main(String[] args) throws ErroridNotFound, ErrorTheBaseDataIsFulls, ErrorVeryOldPilot, ErrorNoCity {
        new Controller();
    }
}
