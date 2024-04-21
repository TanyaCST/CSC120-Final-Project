import java.util.ArrayList;
import java.util.Hashtable;

public class Heart extends SurgicalRobot {
    //Should be able to do:
    //Heart transplant, Heart valve repair or replacement, Coronary artery grafting
    //Methods:
    //transplant(), valveRepair(), valveReplacement(), graftArtery
    private String patient;
    private ArrayList <String> heartParts; //Begin surgery by listing out things you will need and adding that using a for loop
    private Hashtable <String, String> trashNurse = new Hashtable <> (); //Add items to be trasjhed and their disposal locations


    public Heart(String name, double xCoordinate, double yCoordinate, double size, String patient){
        super(name, xCoordinate, yCoordinate, size);
        this.patient = patient;
        this.heartParts = new ArrayList<>();
        this.trashNurse = new Hashtable <> ();
    }

    public void transplant(){
        //next 30 mins on heart transplant
        //Requires a new heart
        //Trashes the old heart
    }

    public void valveRepair(){
        //
    }

    public void valveReplacement(){
        //
    }
    
    public void graftArtery(){

    }
}
