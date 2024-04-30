import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.SourceDataLine;

import org.w3c.dom.UserDataHandler;

public class HeartRobot extends SurgicalRobot {
    //Should be able to do:
    //Heart transplant, Heart valve repair or replacement, Coronary artery grafting
    //Methods:
    //transplant(), valveRepair(), valveReplacement(), graftArtery
    private String name;
    private String patient;
    private ArrayList <String> heartParts; //Begin surgery by listing out things you will need and adding that using a for loop
    private Hashtable <String, String> trashNurse = new Hashtable <> (); //Add items to be trasjhed and their disposal locations
    Random rand = new Random();
    int restTime = 500;


    public HeartRobot(String name, double xCoordinate, double yCoordinate, double size, String patient){
        super(name, xCoordinate, yCoordinate, size);
        this.name = getName();
        this.patient = patient;
        this.heartParts = new ArrayList<>();
        this.trashNurse = new Hashtable <> ();
        
        
    }

    public int transplant(){
        System.out.println("........Evaluating your 1st patient, " + this.patient);
        int grade = rand.nextInt(1, 10);
        System.out.println(this.patient + " has chronic heart failure of grade " + grade );
        if (grade < 6){
            rest(restTime);
            System.out.println("Fortunately, the heart damage is less than 6. A dialysis of the damaged heart would suffice.\nShould call graftArtery()");
        }
        else if (grade >= 6){
            rest(restTime);
            System.out.println("A damage level of " + grade + " is almost irreversible.");
            rest(restTime);
            System.out.println("......The heart needs to be completely replaced. Should call heartReplace()....");
        }
        return grade;
    }


    public int heartReplace(){
        String oldHeart = this.patient + "'s heart";
        String newHeart = "Donor's heart";
        System.out.println("----------------------------------------------------------------------");
        System.out.println("You need the CardioPulmonary By-pass machine to serve as a temporary heart during the process\nThis is also known as the 'Heart-Lung'machine. Enter 1 to approve");
        rest(1000);
        int approveReplacement = userInput.nextInt();
        userInput.nextLine();
        while (approveReplacement != 1){
            System.out.println("You must enter 1 to proceed");
            approveReplacement = userInput.nextInt();
            userInput.nextLine();
        }
        rest(restTime);
        System.out.println("----------------Fixing machine onto heart valve 1. Might take a while-----------");
        rest(10000);
        grab("Heart-Lung Machine");
        this.heartParts.add(newHeart); //Adds newHeart to the inventory
        this.trashNurse.put(oldHeart, " Dispose in waste facility");
        int replacementSucess = rand.nextInt(1,5);
        if (replacementSucess > 3){
        System.out.println(oldHeart + " replaced! Congratulations, " + this.patient + " survived..");}
        if (replacementSucess <= 3){
            System.out.println(oldHeart + " was replaced but unfortunately, " + this.patient + " couldn't make it. Improve techniques next time");
        }
        return replacementSucess;
    }
    
    public void grab(String equipment){
        if (inventory.contains(equipment)){
            System.out.println("---------------------------Grabbing " + equipment + "----------------------------");
        }
    }

    public void valveStitch(String stitchEquipment){
        ArrayList <String> stichType = new ArrayList<String>();
        stichType.add("minor"); stichType.add("major"); stichType.add("medium");
        int lengthStitchType = stichType.size();
        String randomResponse = stichType.get(rand.nextInt(lengthStitchType - 1));
        System.out.println("----------Going through a " + randomResponse + "stitch-------");
        System.out.println("Using " + stitchEquipment + " carefully.");
        //
    }

    
    public void graftArtery(String excisionEquipment, String stitchEquipment){
        System.out.println("Using " + excisionEquipment + " to graft out artery.");
        valveStitch(stitchEquipment);

    }

    public void showOptions(){
        rest(restTime);
        System.out.println(this.name + " can perform the following functions:");
        rest(restTime);
        System.out.println("heartTransplant(), heartReplace(), valveStitch(), and graftArtery()");

    }

    

public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    int score = 0;
    //while or for
    //way to evaluate surgeon
    //welcome greeting
    //3 levels--- 1: transplant() 2:graftArtery() 3:heartReplace()

    System.out.println("🏥🏥Welcome to SurgicalAdventure in Nigeria🇳🇬🏥🏥");
    System.out.println("In this round of surgical adventure, you can use the RAS heart assistant to perform three types of heart surgeries");
    System.out.println("Heart transplant corresponds to level 1\ngraftArtery corresponds to level 2\nheartReplacement corresponds to level 3");
    System.out.println("You must pass each level to get to the next. To quit the game, hit Ctrl +D when prompted 'Enter any value ot continue to level 1.'");
    System.out.println("---------------------Let's get started!--------------------------");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        String input;
        System.out.println("Welcome to heart transplant. Enter any value to continue to level 1");
        while ((input = reader.readLine()) != null) { // readLine returns null on EOF
            //Introduction
            HeartRobot HAS = new HeartRobot("HAS", 0, 0, 30, "Patient A");
            System.out.println(HAS);
            //showOptions()
            System.out.println("Do you want to see the show options? Enter 1 for Yes and 2 for No");
            if ((userInput.nextInt() == 1)){
                HAS.showOptions();
            }
            userInput.nextLine(); //Clears out space
            String welcome1 = ("-------------Welcome to the first level of heart surgical adventure-------\nUpon completing this level, you'll be promoted to level 2 or level 3 depending on your level of surgical expertise.\n---------Enter 1 to agree to the above terms and conditions or 2 to disagree---------");
            System.out.println(welcome1);
            int termsInput = userInput.nextInt();
            while (!(termsInput == 1 | termsInput == 2)){
                System.out.println("Enter 1 or 2 to continue");
                termsInput = userInput.nextInt();
            }
            if (termsInput == 1){}
            else if (termsInput == 2){
                System.out.println("Quitting game! You refused to agree to the stipulated terms of the game");
                System.exit(1);
            }
            userInput.nextLine();
            //termsInput must be 1 to have gotten here
            int heartDamage = HAS.transplant();
                System.out.println("..............." + HAS.name + " is performing a quick dialysis prep on " + HAS.patient);
                HAS.rest(500);
                System.out.println("---------This might take a while. Wait patiently until prompted-------------");
                HAS.rest(10000);
                if (heartDamage < 6){
                System.out.println("Dialysis prep completed! " + "\n......To graft out the infected artery, you'll need an excision equipment and a stitch equipment......");
                HAS.rest(2000);
                System.out.println("Below are possible equipment that can be used");
                HAS.showEquipment();
                System.out.println("By choosing from one of the equipments above, enter the excision equipment you'd like to use.");
                String excisionEquipment = userInput.nextLine().toLowerCase();
                while (!(HAS.allowedEquipment.contains(excisionEquipment))){
                    System.out.println("You must choose from one of the equipments shown");
                    HAS.showEquipment();
                    excisionEquipment = userInput.nextLine().toLowerCase();
                }
                HAS.rest(1000);
                System.out.println("Enter the stitch equipment.");
                String stitchEquipment = userInput.nextLine().toLowerCase();
                while (!(HAS.allowedEquipment.contains(stitchEquipment))){
                    System.out.println("You must choose from one of the equipments shown");
                    HAS.showEquipment();
                    stitchEquipment = userInput.nextLine().toLowerCase();
                    score += 10;
                    System.out.println("-------------------Just completed level 1✅. Moving you to Level 2: graftArtery()🎊🎊----------------"); //implement quit if you like
                }
                HAS.rest(1000);
                HAS.graftArtery(excisionEquipment, stitchEquipment);
                System.out.println("Artery's been successfully grafted✅. Congratsss, you won level 1 and 2!!🎉🎉");
                System.out.println("Your level of expertise qualifies you for level 3");
                score += 20;
                System.out.println("You scored " + score + ". Continue to level 3 to earn more points ");
                HAS.rest(1000);
                System.out.println("Click 1 to continue and 2 to quit game");
                int quitGame = userInput.nextInt();
                userInput.nextLine();
                if (quitGame == 1){
                    heartDamage = 6; //Trick to move user to the next level
                }
                else if (quitGame == 2){
                    System.out.println("End of input detected. Exiting.");
                    System.exit(1);}
            }
            if (heartDamage > 5){
                score += 30;
                System.out.println("Dialysis prep completed! " + "\n......To replace heart, you'll need a new heart from a donor. Enter 1 if that's available......");
                int newHeart = userInput.nextInt();
                while (newHeart != 1){
                    System.out.println("You can't proceed if you don't have the new heart. Enter 1 when that becomes available.");
                    newHeart = userInput.nextInt();
                    userInput.nextLine();
                } 
                int sucessReplace = HAS.heartReplace(); // must be 1 to get here
                if (sucessReplace <= 3){
                    score -= 10;
                    System.out.println("Congrats on completing level 3\nUnfortunately, you lost the game for losing the patient");
                    HAS.rest(HAS.restTime);
                    System.out.println("Your final score is " + score);
                    System.exit(1);
                }
                if (sucessReplace > 3){
                    score += 30;
                    System.out.println("You completed the most difficult level! You are officially a surgeon🎉🎊🤣");
                    HAS.rest(1000);
                    System.out.println("Your final score is pretty high: " + score + "points. You should be proud of yourself.");
                    System.exit(1);
                }    
        }}
            System.out.println("End of input detected. Exiting.");
     }
         catch(IOException e) {
        e.printStackTrace();
    }
}
}







