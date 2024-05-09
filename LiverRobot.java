
import java.util.*;
import java.util.Random;

public class LiverRobot extends SurgicalRobot {

    private String name;
    private String patient;
    private boolean cutOpen;
    private boolean anesthesiaAdministered;
    private boolean choiceMade;
    private boolean oldLiver;
    private boolean newLiver;
    private boolean probeInserted;
    private boolean tubeInserted;
    Scanner surgicalStepScanner = new Scanner(System.in);

    /**
     * LiverRobot constructor
     * @param name
     * @param xCoordinate
     * @param yCoordinate
     * @param size
     * @param patient
     */
    public LiverRobot(String name, double xCoordinate, double yCoordinate, double size, String patient){
        super(name, xCoordinate, yCoordinate, size);
        this.name = name;
        this.patient = patient;
    }


    /**
     * This checks to see if the player has administered anesthesia.
     */
    public void anesthesia(){
        anesthesiaAdministered = false;

        System.out.println("\nFirst, we need to administer anesthesia. Please enter \"a\" to administer anesthesia");
        String surgicalAnesthesiaInput = surgicalStepScanner.nextLine();

        if (surgicalAnesthesiaInput.toLowerCase().equals("a")){
            anesthesiaAdministered = true;
        }
        while (anesthesiaAdministered == false){ // This makes sure the player administers anesthesia before moving on
            System.out.println("\nPlease enter \"a\" to administer anesthesia. You cannot operate on a patient that hasn't been anesthetized.");
            String surgicalAnesthesiaInput2 = surgicalStepScanner.nextLine();
            if (surgicalAnesthesiaInput2.toLowerCase().equals("a")){
                anesthesiaAdministered = true;
            }
        }
        System.out.println("\nWell done! You have administered anesthesia!");
    }


    /**
     * This checks to see if the player has made an incision on the patient
     */
    public void cut(){
        cutOpen = false;

        System.out.println("\nNow, please make an incision. Enter \"cut\" to make an incision.");
        String surgicalIncisionInput = surgicalStepScanner.nextLine();
        if (surgicalIncisionInput.toLowerCase().equals("cut")){
            cutOpen = true;
        }
        while (cutOpen == false){ // This makes sure the player makes an incision before moving on
            System.out.println("\nPlease enter \"cut\" to make an incision. You cannot do anything to the liver with no access to the liver.");
            String surgicalIncisionInput2 = surgicalStepScanner.nextLine();
            if (surgicalIncisionInput2.toLowerCase().equals("cut")){
                cutOpen = true;
            }
        }
        System.out.println("\nWell done! You have made an incision!");
    }

    /**
     * This checks to see if the player has closed the incision on the patient.
     */
    public void closeCut(){
        String surgicalClosureInput = surgicalStepScanner.nextLine();
        if (surgicalClosureInput.toLowerCase().equals("close")){
            cutOpen = false;
        }
        while (cutOpen == true){ //This makes sure the player closes the incision before moving on
            System.out.println("\nPlease enter \"close\" to close the cut. You cannot leave an incision open!");
            String surgicalClosureInput2 = surgicalStepScanner.nextLine();
            if (surgicalClosureInput2.toLowerCase().equals("close")){
                cutOpen = false;
            }
        }
    }


    /**
     * This is the liver transplant surgery, users have to go through the steps
     */
    public void liverTransplant(){
        System.out.println("\nTo perform a liver transplant, administer anesthesia, cut the patient open, remove the liver, replace it, and stitch the patient closed.");
        anesthesia();
        cut();

        System.out.println("\nNow, we need to replace the liver. Enter \"remove and replace\" to do so."); // Removes and replaces the old liver with a new liver
        String surgicalLiverReplacementInput = surgicalStepScanner.nextLine();
        if (surgicalLiverReplacementInput.toLowerCase().equals("remove and replace")){
            System.out.println("\nDone! Now, please stitch the patient closed.");
            oldLiver = false;
            newLiver = true;
        }
        while (oldLiver == true && newLiver == false){ // Makes sure the player transplants the liver
            System.out.println("\nPlease replace the liver. Enter \"remove and replace\" to do so, otherwise you have not completed the surgery.");
            String surgicalLiverReplacementInput2 = surgicalStepScanner.nextLine();
            if (surgicalLiverReplacementInput2.toLowerCase().equals("remove and replace")){
                System.out.println("\nLiver transplant done! Now, please stitch the patient closed.");
                oldLiver = false;
                newLiver = true;
            }
        }

        System.out.println("\nPlease close the cut by typing \"close\".");
        closeCut();

        System.out.println("\nWell done! You have now completed a liver transplant.");
    }

    /**
     * This is the liver ablation surgery, users have to go through the steps
     */
    public void liverAblation(){
        probeInserted = false;


        System.out.println("\nTo perform a liver ablation, administer anesthesia, insert a needle, and pass a current through the tip of the probe.");
        anesthesia();
        
        System.out.println("\nNext, we need to insert the probe. Please enter \"insert\" to insert the probe."); // Inserts the probe
        String surgicalInsertionInput = surgicalStepScanner.nextLine();
        if (surgicalInsertionInput.toLowerCase().equals("insert")){
            probeInserted = true;
            System.out.println("\nThe current has been passed.");
        }
        while (probeInserted == false){ // Ensures the player inserts the probe
            System.out.println("\nPlease enter \"insert\" to insert the probe. You need to pass a current through the probe into the patient, not the air.");
            String surgicalInsertionInput2 = surgicalStepScanner.nextLine();
            if (surgicalInsertionInput2.toLowerCase().equals("insert")){
                probeInserted = true;
                System.out.println("\nThe current has been passed.");
            }
        }


        System.out.println("\nNow, we need to remove the probe. Enter \"remove\""); //Removes the probe
        String surgicalRemovalInput = surgicalStepScanner.nextLine();
        if (surgicalRemovalInput.toLowerCase().equals("remove")){
            System.out.println("\nDone!");
            probeInserted = false;
        }
        while (probeInserted == true){ // Makes sure the probe is removed
            System.out.println("\nPlease remove the probe. Enter \"remove\".");
            String surgicalRemovalInput2 = surgicalStepScanner.nextLine();
            if (surgicalRemovalInput2.toLowerCase().equals("remove")){
                System.out.println("\nDone!");
                probeInserted = false;
            }
        }
        
        System.out.println("\nThe tumor has now been heated and destroyed! You have completed a liver ablation.\nThis ablation performed was Radiofrequency Ablation (RFA). There's also Microwave Ablation (MWA), Cryoablation, and Ethanol Ablation.");
    }


    /**
     * This is the liver resection surgery, users have to go through the steps
     */
    public void liverResection(){
        oldLiver = true;
        newLiver = false;

        System.out.println("\nTo perform a liver resection, administer anesthesia, cut the patient open, remove a part of the liver, and stitch the patient closed.");
        anesthesia();
        cut();

        System.out.println("\nNext, remove a section of the liver. Enter \"remove\" to do so."); // Removes old liver
        String surgicalRemovalInput = surgicalStepScanner.nextLine();

        if (surgicalRemovalInput.toLowerCase().equals("remove")){
            oldLiver = false;
            newLiver = true; // Not an entirely new liver, but without the previous section
            System.out.println("\nDone! Now, please stitch the patient closed.");
        }

        while (oldLiver == true && newLiver == false){ // Ensures the player removes part of the liver
            System.out.println("\nPlease remove a section of the liver. Enter \"remove\" to do so.");
            String surgicalRemovalInput2 = surgicalStepScanner.nextLine();
            if (surgicalRemovalInput2.toLowerCase().equals("remove")){
                System.out.println("\nDone! Now, please stitch the patient closed.");
                oldLiver = false;
                newLiver = true;
            }
        }

        System.out.println("\nLiver resection done! Please close the cut by typing \"close\".");
        closeCut();
    }


    /**
     * This is the diagnostic laparoscopy, users have to go through the steps
     */
    public void diagnosticLaparoscopy(){
        System.out.println("\nTo perform a diagnostic laparoscopy, please make a small incision, then insert a tube with a camera to see. Administer anesthesia, make a cut, insert the tube, then stitch the incision closed.");
        anesthesia();

        cut();

        tubeInserted = false;
        System.out.println("\nNow, insert the tube with the camera. Enter \"insert\" to put in the tube."); // Inserts the tube
        String surgicalInsertionInput = surgicalStepScanner.nextLine();
        if (surgicalInsertionInput.toLowerCase().equals("insert")){
            tubeInserted = true;
        }
        while (tubeInserted == false){ // Makes sure the tube is inserted
            System.out.println("\nPlease type \"insert\" to insert the tube. If you don't insert the tube, the examination cannot be completed.");
            String surgicalInsertionInput2 = surgicalStepScanner.nextLine();
            if (surgicalInsertionInput2.toLowerCase().equals("insert")){
                tubeInserted = true;
            }
        }
        
        System.out.println("\nExamination done! No conditions detected! Please close the incision by typing \"close\".");
        closeCut();

        System.out.println("\nGood job! You have now completed a diagnostic laparoscopy!");
    }



    public static void main(String[] args) {
        System.out.println("Welcome to the Liver Robot game!\n==============================\n");
        System.out.println("Press 1 to start the game, press any other key to quit.");
        LiverRobot liverRobot = new LiverRobot("Liver Robot", 0, 0, 50, "Patient 1");
        Scanner userScanner = new Scanner(System.in); // Initiatlizes a scanner for user input
        String userInput = userScanner.nextLine();
        
        if (userInput.contains("1")){ // Starts the game
            boolean choiceMade = true;
        
            while (choiceMade){
                System.out.println("Please wait while we give your patient a checkup...\nIf the severity value is above 3, you must perform a liver transplant. \nIf the severity level is 2, then you must perform a liver ablation. \nIf the severity level is 1, you must perform a liver resection.\nIf the severity level is 0, you can choose to perform a diagnostic laparoscopy.\n");
                Random rand = new Random();
                int liverCondition = rand.nextInt(0, 6);
                System.out.println(".....................................................\n");
                
                if (liverCondition >= 3){ //Starts liver transplant surgery
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver transplant.\nLiver Transplant: Surgery to replace a diseased liver with a healthy liver from another person. It is usually reserved as a treatment option for people who have significant complications.\n");
                    liverRobot.liverTransplant();
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine(); // If the user enters anything but "e", the game loops and continues
                    if (userChoice.toLowerCase().contains("e")){ // Exits game
                        choiceMade = false;
                    }
                }
                
                else if (liverCondition == 2){ //Starts liver ablation surgery
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver ablation.\nLiver Ablation: Using heat to destroy liver tumors. This is best used when tumors are no larger than a little over an inch across.\n");
                    liverRobot.liverAblation();
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine(); // If the user enters anything but "e", the game loops and continues
                    if (userChoice.toLowerCase().contains("e")){ // Exits game
                        choiceMade = false;
                    }
                }
                
                else if (liverCondition == 1){ //Starts liver resection surgery
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver resection.\nLiver Resection: The removal of part of the liver during an operation.\n");
                    liverRobot.liverResection();
                    
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine(); // If the user enters anything but "e", the game loops and continues
                    if (userChoice.toLowerCase().contains("e")){ // Exits game
                        choiceMade = false;
                    }
                }
                
                else if (liverCondition == 0){ //Starts diagnostic laproscopy operation
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a diagnostic laproscopy.\n");
                    liverRobot.diagnosticLaparoscopy();
                    
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine(); // If the user enters anything but "e", the game loops and continues
                    if (userChoice.toLowerCase().contains("e")){ // Exits game
                        choiceMade = false;
                    }
                }             
            }

        }
        
        else{ // Exits the game
            System.out.println("T");
            System.exit(0);
        }
        userScanner.close(); // Closes scanner to make sure there's no leak
    }

}