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

    public LiverRobot(String name, double xCoordinate, double yCoordinate, double size, String patient){
        super(name, xCoordinate, yCoordinate, size);
        this.name = name;
        this.patient = patient;
    }


    public void anesthesia(){
        anesthesiaAdministered = false;

        System.out.println("First, we need to administer anesthesia. Please enter \"a\" to administer anesthesia");
        String surgicalAnesthesiaInput = surgicalStepScanner.nextLine();

        if (surgicalAnesthesiaInput.toLowerCase().equals("a")){
            anesthesiaAdministered = true;
        }
        while (anesthesiaAdministered == false){
            System.out.println("Please enter \"a\" to administer anesthesia. You cannot operate on a patient that hasn't been anesthetized.");
            String surgicalAnesthesiaInput2 = surgicalStepScanner.nextLine();
            if (surgicalAnesthesiaInput2.toLowerCase().equals("a")){
                anesthesiaAdministered = true;
            }
        }
        System.out.println("Well done! You have administered anesthesia!");
    }

    public void cut(){
        cutOpen = false;

        System.out.println("Now, please make an incision. Enter \"cut\" to make an incision.");
        String surgicalIncisionInput = surgicalStepScanner.nextLine();
        if (surgicalIncisionInput.toLowerCase().equals("cut")){
            cutOpen = true;
        }
        while (cutOpen == false){
            System.out.println("Please enter \"cut\" to make an incision. You cannot do anything to the liver with no access to the liver.");
            String surgicalIncisionInput2 = surgicalStepScanner.nextLine();
            if (surgicalIncisionInput2.toLowerCase().equals("cut")){
                cutOpen = true;
            }
        }
        System.out.println("Well done! You have made an incision!");
    }

    public void closeCut(){
        String surgicalClosureInput = surgicalStepScanner.nextLine();
        if (surgicalClosureInput.toLowerCase().equals("close")){
            cutOpen = false;
        }
        while (cutOpen == true){
            System.out.println("Please enter \"close\" to close the cut. You cannot leave an incision open!");
            String surgicalClosureInput2 = surgicalStepScanner.nextLine();
            if (surgicalClosureInput2.toLowerCase().equals("close")){
                cutOpen = false;
            }
        }
    }

    public void liverTransplant(){
        System.out.println("To perform a liver transplant, administer anesthesia, cut the patient open, remove the liver, replace it, and stitch the patient closed.");
        anesthesia();
        cut();

        System.out.println("Now, we need to replace the liver. Enter \"remove and replace\" to do so.");
        String surgicalLiverReplacementInput = surgicalStepScanner.nextLine();
        if (surgicalLiverReplacementInput.toLowerCase().equals("remove and replace")){
            System.out.println("Done! Now, please stitch the patient closed.");
            oldLiver = false;
            newLiver = true;
        }
        while (oldLiver == true && newLiver == false){
            System.out.println("Please replace the liver. Enter \"remove and replace\" to do so, otherwise you have not completed the surgery.");
            String surgicalLiverReplacementInput2 = surgicalStepScanner.nextLine();
            if (surgicalLiverReplacementInput2.toLowerCase().equals("remove and replace")){
                System.out.println("Liver transplant done! Now, please stitch the patient closed.");
                oldLiver = false;
                newLiver = true;
            }
        }

        System.out.println("Please close the cut by typing \"close\".");
        closeCut();

        System.out.println("Well done! You have now completed a liver transplant.");
    }

    public void liverAblation(){
        probeInserted = false;


        System.out.println("To perform a liver ablation, administer anesthesia, insert a needle, and pass a current through the tip of the probe.");
        anesthesia();
        
        System.out.println("Next, we need to insert the probe. Please enter \"insert\" to insert the probe.");
        String surgicalInsertionInput = surgicalStepScanner.nextLine();
        if (surgicalInsertionInput.toLowerCase().equals("insert")){
            probeInserted = true;
            System.out.println("The current has been passed.");
        }
        while (probeInserted == false){
            System.out.println("Please enter \"insert\" to insert the probe. You need to pass a current through the probe into the patient, not the air.");
            String surgicalInsertionInput2 = surgicalStepScanner.nextLine();
            if (surgicalInsertionInput2.toLowerCase().equals("insert")){
                probeInserted = true;
                System.out.println("The current has been passed.");
            }
        }


        System.out.println("Now, we need to remove the probe. Enter \"remove\"");
        String surgicalRemovalInput = surgicalStepScanner.nextLine();
        if (surgicalRemovalInput.toLowerCase().equals("remove")){
            System.out.println("Done!");
            probeInserted = false;
        }
        while (probeInserted == true){
            System.out.println("Please remove the probe. Enter \"remove\".");
            String surgicalRemovalInput2 = surgicalStepScanner.nextLine();
            if (surgicalRemovalInput2.toLowerCase().equals("remove")){
                System.out.println("Done!");
                probeInserted = false;
            }
        }
        
        System.out.println("The tumor has now been heated and destroyed! You have completed a liver ablation.\nThis ablation performed was Radiofrequency Ablation (RFA). There's also Microwave Ablation (MWA), Cryoablation, and Ethanol Ablation.");
    }

    public void liverResection(){
        oldLiver = true;
        newLiver = false;

        System.out.println("To perform a liver resection, administer anesthesia, cut the patient open, remove a part of the liver, and stitch the patient closed.");
        anesthesia();
        cut();

        System.out.println("Next, remove a section of the liver. Enter \"remove\" to do so.");
        String surgicalRemovalInput = surgicalStepScanner.nextLine();

        if (surgicalRemovalInput.toLowerCase().equals("remove")){
            oldLiver = false;
            newLiver = true;
            System.out.println("Done! Now, please stitch the patient closed.");
        }

        while (oldLiver == true && newLiver == false){
            System.out.println("Please remove a section of the liver. Enter \"remove\" to do so.");
            String surgicalRemovalInput2 = surgicalStepScanner.nextLine();
            if (surgicalRemovalInput2.toLowerCase().equals("remove")){
                System.out.println("Done! Now, please stitch the patient closed.");
                oldLiver = false;
                newLiver = true;
            }
        }

        System.out.println("Liver resection done! Please close the cut by typing \"close\".");
        closeCut();
    }

    public void diagnosticLaparoscopy(){
        System.out.println("To perform a diagnostic laparoscopy, please make a small incision, then insert a tube with a camera to see. Administer anesthesia, make a cut, insert the tube, then stitch the incision closed.");
        anesthesia();

        cut();

        tubeInserted = false;
        System.out.println("Now, insert the tube with the camera. Enter \"insert\" to put in the tube.");
        String surgicalInsertionInput = surgicalStepScanner.nextLine();
        if (surgicalInsertionInput.toLowerCase().equals("insert")){
            tubeInserted = true;
        }
        while (tubeInserted == false){
            System.out.println("Please type \"insert\" to insert the tube. If you don't insert the tube, the examination cannot be completed.");
            String surgicalInsertionInput2 = surgicalStepScanner.nextLine();
            if (surgicalInsertionInput2.toLowerCase().equals("insert")){
                tubeInserted = true;
            }
        }
        
        System.out.println("Examination done! No conditions detected! Please close the incision by typing \"close\".");
        closeCut();

        System.out.println("Good job! You have now completed a diagnostic laparoscopy!");
    }



    public static void main(String[] args) {
        System.out.println("Welcome to the Liver Robot game!\n==============================\n");
        System.out.println("Press 1 to start the game, press any other key to quit.");
        LiverRobot liverRobot = new LiverRobot("Liver Robot", 0, 0, 50, "Patient 1");
        Scanner userScanner = new Scanner(System.in);
        String userInput = userScanner.nextLine();
        
        if (userInput.contains("1")){
            boolean choiceMade = true;
        
            while (choiceMade){
                System.out.println("Please wait while we give your patient a checkup...\nIf the severity value is above 3, you must perform a liver transplant. \nIf the severity level is 2, then you must perform a liver ablation. \nIf the severity level is 1, you must perform a liver resection.\nIf the severity level is 0, you can choose to perform a diagnostic laparoscopy.");
                Random rand = new Random();
                int liverCondition = rand.nextInt(0, 6);
                System.out.println(".....................................................");
                
                if (liverCondition >= 3){
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver transplant.\nLiver Transplant: Surgery to replace a diseased liver with a healthy liver from another person. It is usually reserved as a treatment option for people who have significant complications.");
                    liverRobot.liverTransplant();
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine();
                    if (userChoice.toLowerCase().contains("e")){
                        choiceMade = false;
                    }
                }
                
                else if (liverCondition == 2){
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver ablation.\nLiver Ablation: Using heat to destroy liver tumors. This is best used when tumors are no larger than a little over an inch across.");
                    liverRobot.liverAblation();
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine();
                    if (userChoice.toLowerCase().contains("e")){
                        choiceMade = false;
                    }
                }
                
                else if (liverCondition == 1){
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver resection.\nLiver Resection: The removal of part of the liver during an operation.");
                    liverRobot.liverResection();
                    
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine();
                    if (userChoice.toLowerCase().contains("e")){
                        choiceMade = false;
                    }
                }
                
                else if (liverCondition == 0){
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a diagnostic laproscopy.");
                    liverRobot.diagnosticLaparoscopy();
                    
                    System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                    String userChoice = userScanner.nextLine();
                    if (userChoice.toLowerCase().contains("e")){
                        choiceMade = false;
                    }
                }             
            }

        }
        
        else{
            System.out.println("T");
            System.exit(0);
        }
        userScanner.close();
    }

}