import java.util.*;
import java.util.ArrayList;
import java.util.Random;

public class Liver extends SurgicalRobot {

    private String name;
    private String patient;
    private boolean cutOpen;
    private boolean anesthesiaAdministered;
    private boolean choiceMade;
    private boolean oldLiver;
    private boolean newLiver;
    private boolean probeInserted;

    public Liver(String name, double xCoordinate, double yCoordinate, double size, String patient){
        super(name, xCoordinate, yCoordinate, size);
        this.name = name;
        this.patient = patient;
    }

    public void liverTransplant(Liver liverRobot){
        Scanner surgicalStepScanner = new Scanner(System.in);
        String surgicalStepInput = surgicalStepScanner.nextLine();
        anesthesiaAdministered = false;
        cutOpen = false;
        oldLiver = true;
        newLiver = false;

        System.out.println("To perform a liver transplant, administer anesthesia, cut the patient open, remove the liver, replace it, and stitch the patient closed.");
        System.out.println("First, we need to administer anesthesia.");
        while (anesthesiaAdministered = false){
            System.out.println("Please enter \"a\" to administer anesthesia. You cannot operate on a patient that hasn't been anesthetized.");
            if (surgicalStepInput.toLowerCase().equals("a")){
                anesthesiaAdministered = true;
            }
        }
        
        while (cutOpen == false){
            System.out.println("Please enter \"cut\" to make an incision. You cannot transplant a liver with no access to the liver.");
            if (surgicalStepInput.toLowerCase().equals("cut")){
                cutOpen = true;
            }
        }

        while (oldLiver == true && newLiver == false){
            System.out.println("Please replace the liver. Enter \"remove and replace\" to do so.");
            if (surgicalStepInput.toLowerCase().equals("remove and replace")){
                System.out.println("Done! Now, please stitch the patient closed.");
                oldLiver = false;
                newLiver = true;
            }
        }

        System.out.println("Liver transplant done! Please close the cut by typing \"close\".");
        while (cutOpen == true){
            System.out.println("Please enter \"close\" to close the cut. You cannot leave an incision open!");
            if (surgicalStepInput.toLowerCase().equals("close")){
                cutOpen = false;
            }
        }
        System.out.println("Well done! You have now completed a liver transplant.");

        surgicalStepScanner.close();


    }

    public void liverAblation(Liver liverRobot){
        Scanner surgicalStepScanner = new Scanner(System.in);
        String surgicalStepInput = surgicalStepScanner.nextLine();
        anesthesiaAdministered = false;
        probeInserted = false;

        System.out.println("To perform a liver ablation, administer anesthesia, insert a needle, and pass a current through the tip of the probe.");
        System.out.println("First, we need to administer anesthesia.");
        while (anesthesiaAdministered = false){
            System.out.println("Please enter \"a\" to administer anesthesia. You cannot operate on a patient that hasn't been anesthetized.");
            if (surgicalStepInput.toLowerCase().equals("a")){
                anesthesiaAdministered = true;
            }
        }
        
        while (probeInserted == false){
            System.out.println("Please enter \"insert\" to insert the probe. You need to pass a current through the probe into the patient, not the air.");
            if (surgicalStepInput.toLowerCase().equals("insert")){
                probeInserted = true;
                System.out.println("The current has been passed.");
            }
        }

        while (probeInserted ==true){
            System.out.println("Please remove the prove. Enter \"remove\".");
            if (surgicalStepInput.toLowerCase().equals("remove")){
                System.out.println("Done!");
            }
        }
        
        System.out.println("The tumor has now been heated and destroyed! You have completed a liver ablation.\nThis ablation performed was Radiofrequency Ablation (RFA). There's also Microwave Ablation (MWA), Cryoablation, and Ethanol Ablation.");

        surgicalStepScanner.close();
    }

    public void liverResection(Liver liverRobot){
        Scanner surgicalStepScanner = new Scanner(System.in);
        String surgicalStepInput = surgicalStepScanner.nextLine();
        anesthesiaAdministered = false;
        cutOpen = false;
        oldLiver = true;
        newLiver = false;

        System.out.println("To perform a liver resection, administer anesthesia, cut the patient open, remove a part of the liver, and stitch the patient closed.");
        System.out.println("First, we need to administer anesthesia.");
        while (anesthesiaAdministered = false){
            System.out.println("Please enter \"a\" to administer anesthesia. You cannot operate on a patient that hasn't been anesthetized.");
            if (surgicalStepInput.toLowerCase().equals("a")){
                anesthesiaAdministered = true;
            }
        }
        
        while (cutOpen == false){
            System.out.println("Please enter \"cut\" to make an incision. You cannot resection a liver with no access to the liver.");
            if (surgicalStepInput.toLowerCase().equals("cut")){
                cutOpen = true;
            }
        }

        while (oldLiver == true && newLiver == false){
            System.out.println("Please remove a section of the liver. Enter \"remove\" to do so.");
            if (surgicalStepInput.toLowerCase().equals("remove")){
                System.out.println("Done! Now, please stitch the patient closed.");
                oldLiver = false;
                newLiver = true;
            }
        }

        System.out.println("Liver resection done! Please close the cut by typing \"close\".");
        while (cutOpen == true){
            System.out.println("Please enter \"close\" to close the cut. You cannot leave an incision open!");
            if (surgicalStepInput.toLowerCase().equals("close")){
                cutOpen = false;
            }
        }
        System.out.println("Well done! You have now completed a liver resection.\nFun fact: The liver is the only organ in the body that can replace lost or injured tissue (regenerate).");

        surgicalStepScanner.close();
    }

    public void diagnosticLaparoscopy(Liver liverRobot){
        Scanner surgicalStepScanner = new Scanner(System.in);
        String surgicalStepInput = surgicalStepScanner.nextLine();
        anesthesiaAdministered = false;
        cutOpen = false;

        System.out.println("To perform a diagnostic laparoscopy, please make a small incision, then insert a tube with a camera to see. Administer anesthesia, make a cut, insert the tube, then stitch the incision closed.");
        while (anesthesiaAdministered == false){
            System.out.println("Please enter \"a\" to administer anesthesia. You cannot operate on a patient that hasn't been anesthetized.");
            if (surgicalStepInput.toLowerCase().equals("a")){
                anesthesiaAdministered = true;
            }
        }
        
        
        while (cutOpen == false){
            System.out.println("Please enter \"cut\" to make an incision. You cannot insert a tube if there is no incision to put it into.");
            if (surgicalStepInput.toLowerCase().equals("cut")){
                cutOpen = true;
            }
        }
        
        System.out.println("Now, insert the tube with the camera. Enter \"insert\" to put in the tube.");
        while (!surgicalStepInput.toLowerCase().equals("insert")){
            System.out.println("Please enter \"insert\" to put in the tube.");
        }
        
        System.out.println("Examination done! No conditions detected! Please close the incision by typing \"close\".");
        while (cutOpen == true){
            System.out.println("Please enter \"close\" to close the incision. You cannot leave an incision open!");
            if (surgicalStepInput.toLowerCase().equals("close")){
                cutOpen = false;
            }
        }

        System.out.println("Good job! You have now completed a diagnostic laparoscopy!");

        surgicalStepScanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Liver Robot game!\n==============================\n");
        System.out.println("Press 1 to start the game, press any other key to quit.");
        Liver liverRobot = new Liver("Liver Robot", 0, 0, 50, "Patient 1");
        Scanner userScanner = new Scanner(System.in);
        String userInput = userScanner.nextLine();
        boolean cutOpen = false;
        boolean anesthesiaAdministered = false;
        
        if (userInput.contains("1")){
            boolean choiceMade = true;
            
            while (choiceMade == true){
                System.out.println("Please wait while we give your patient a checkup...\nIf the severity value is above 3, you must perform a liver transplant. \nIf the severity level is 2, then you must perform a liver ablation. \nIf the severity level is 1, you must perform a liver resection.\nIf the severity level is 0, you can choose to perform a diagnostic laparoscopy.");
                Random rand = new Random();
                int liverCondition = rand.nextInt(0, 6);
                System.out.println(".....................................................");
                if (liverCondition > 3){
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver transplant.\nLiver Transplant: Surgery to replace a diseased liver with a healthy liver from another person. It is usually reserved as a treatment option for people who have significant complications.");
                    liverRobot.liverTransplant(liverRobot);
                }
                
                else if (liverCondition == 2){
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver ablation.\nLiver Ablation: Using heat to destroy liver tumors. This is best used when tumors are no larger than a little over an inch across.");
                    liverRobot.liverAblation(liverRobot);
                }
                
                else if (liverCondition == 1){
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Please perform a liver resection.\nLiver Resection: The removal of part of the liver during an operation.");
                    liverRobot.liverResection(liverRobot);
                }
                
                else{
                    System.out.println("The severity of the patient's condition is " + liverCondition + ". Do you want to perform a diagnostic laproscopy?");
                    liverRobot.diagnosticLaparoscopy(liverRobot);
                }
                System.out.println("Would you like to perform another surgery? Please press \"e\" to exit, press anything else to continue.");
                if (userInput.toLowerCase().contains("e")){
                    choiceMade = false;
                }
                else{
                    continue;
                }
            }
    
        }
        else{
            System.exit(0);
        }
        

        while (anesthesiaAdministered = false){
            System.out.println("Please enter \"a\" to administer anesthesia! You cannot operate on a patient that hasn't been anesthetized.");
            if (userInput.toLowerCase().equals("a")){
                anesthesiaAdministered = true;
            }
        }

        
        userScanner.close();   
    }  
}
