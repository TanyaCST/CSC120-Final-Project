import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class HeartRobot extends SurgicalRobot {
    //Should be able to do:
    //Heart transplant, Heart valve repair or replacement, Coronary artery grafting
    //Methods:
    //transplant(), valveRepair(), valveReplacement(), graftArtery
    private String patient;
    private ArrayList <String> heartParts; //Begin surgery by listing out things you will need and adding that using a for loop
    private Hashtable <String, String> trashNurse = new Hashtable <> (); //Add items to be trasjhed and their disposal locations
    Random rand = new Random();


    public HeartRobot(String name, double xCoordinate, double yCoordinate, double size, String patient){
        super(name, xCoordinate, yCoordinate, size);
        this.name = name;
        this
        this.patient = patient;
        this.heartParts = new ArrayList<>();
        this.trashNurse = new Hashtable <> ();
        this.userInput = userInput;
    }

    public void transplant(){
        System.out.println("........Evaluating " + this.patient);
        int grade = rand.nextInt(1, 10);
        System.out.println(this.patient + " has chronic heart failure of grade " + grade );
        if (grade < 6){
            System.out.println("Fortunately, the heart damage is less than 6. A dialysis of the damaged heart would suffice.\nShould call graftArtery()");
        }
        else if (grade >= 6){
            System.out.println("A damage level of " + grade + " is almost irreversible. ");
            System.out.println("The heart needs to be completely replaced. Should call heartReplace()");
        }
    }


    public void heartReplace(String oldHeart, String newHeart){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("You need the CardioPulmonary By-pass machine to serve as a temporary heart during the process\nThis is also known as the 'Heart-Lung' machine.");
        grab("Heart-Lung Machine");
        this.heartParts.add(newHeart); //Adds newHeart to the inventory
        this.trashNurse.put(oldHeart, " Dispose in waste facility");
        System.out.println(oldHeart + " replaced! Congratulations, " + this.patient + "survived..") ;
    }
    
    public void grab(String equipment){
        if (inventory.contains(equipment)){
            System.out.println("Grabbing " + equipment);
        }
    }

    public void valveStitch(){
        ArrayList <String> stichType = new ArrayList<String>();
        stichType.add("minor"); stichType.add("major"); stichType.add("medium");
        int lengthStitchType = stichType.size();
        String randomResponse = stichType.get(rand.nextInt(lengthStitchType - 1));
        System.out.println("----------Going through a " + randomResponse + "stitch-------");
        //
    }

    
    public void graftArtery(String excisionEquipment, String stitchEquipment){
        System.out.println("Using " + excisionEquipment + "to graft out artery.");
        valveStitch();

    }

    public void showOptions(){
        rest(500);
        System.out.println(this.name + " can perform the following functions:");
        rest(1000)

    }

public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    //while or for
    //way to evaluate surgeon
    //welcome greeting
    //3 levels--- 1: transplant() 2:graftArtery() 3:heartReplace()

    System.out.println("🏥🏥Welcome to SurgicalAdventure in Nigeria🇳🇬🏥🏥");
    System.out.println("In this round of surgical adventure, you can use the RAS heart assistant to perform three types of heart surgeries");
    System.out.println("Heart transplant corresponds to level 1\ngraftArtery corresponds to level 2\nheartReplacement corresponds to level 3");
    System.out.println(" You must pass each level to get to the next. To quit the game, hit Ctrl +D after which your score will be displayed.");
    System.out.println("---------------------Let's get started!--------------------------");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        String input;
        System.out.println("Welcome to heart transplant. Enter any value to continue to level 1");
        while ((input = reader.readLine()) != null) { // readLine returns null on EOF
            HeartRobot HAS = new HeartRobot("HAS", 0, 0, 30, "Patient A");
            System.out.println(HAS);
            System.out.println("Do you want to see the show options? Enter 1 for Yes and 2 for No or Ctrl D to exit");
            if (!(userInput.nextInt() == 1)){
                HAS.showOptions();
            }

            



        }
        System.out.println("End of input detected. Exiting.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}






