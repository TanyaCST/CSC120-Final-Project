import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Brain extends SurgicalRobot{
    // Create constrcuter - robot name, direction, size, patients, brain parts, more?
    // methods needs to be specific - related to different parts of brain 
    private String name;
    private String patientName;
    private ArrayList <String> brainParts; // lobes, brainstem, etc.
    // private ArrayList <String> trash;
    
    /**
     * Constructor
     */
    public Brain(String name, double xCoordinate, double yCoordinate, double size, String patientName, ArrayList <String> brainParts){
        super(name, xCoordinate, yCoordinate, size);
        this.name = getName();
        this.patientName = patientName;
        this.brainParts = brainParts;
    }

    // getters in Brain class
    /**
     * 
     */
    public String getPatientName(){
        return this.patientName;
    }

    /**
     * 
     */
    public ArrayList<String> getBrainParts(){
        return this.brainParts;
    }

    // Methods: showOption, grab, drop, hemorrage, hematoma, tumor
    /**
     * 
     */
    public void showOptions(){
        System.out.println(name + "can perform:");
        System.out.println("");
    }

    public int chooseSurgery(){
        Random rand = new Random();
        int surgeryNum = rand.nextInt(1, 3);
        return surgeryNum;
    }

    public int grading(){
        Random rand = new Random();
        int grading = rand.nextInt(1,10);
        return grading;
    }

    public void guide(){
        // General guide for all surgeries in Brain robot
        // Bascially, tell users what are equipments needed for each surgery and steps to accomplish the surgeries
        // equipments (in general): forceps, suction tubes, surgical knives, 

        // hemorrage 

        // hematoma

        // brain tumor

    }

    /** 
     * 
     */
    public void hemorrage(){
        // Steps of surgery
        // (maybe) add a brief explanation/definition of hemorrage as people might have difficulties in understanding it
        // Draw the "route" of where to open
        // "open" patient's brain
        // Find the brain part that needs surgery
        // equipments needed:
        System.out.println("....Examinig patient...");
        int grade = grading();
        Scanner userChoice = new Scanner(System.in);
        String choice = userChoice.nextLine();
        if(grade >= 5){
            System.out.println("This patient fails to pass the hemorrage grading. With a grading " + grade +", Surgery is needed");
            System.out.println("Do you want a guide for hemorrage? (Yes/No)");
            if(choice == "Yes" || choice == "YES" || choice == "yes"){
                
            }

        }
        else{
            System.out.println("Fortunately, this patient doesn't have hemorrage.");
        }
        userChoice.close();
    }

    /**
     * 
     */
    public void hematoma(){
        //Steps of surgery
        // (maybe) add a brief explanation/definition of hemorrage as people might have difficulties in understanding it
        // Draw the "route" of where to open
        // "open" patient's brain
        // Find the brain part that needs surgery
        System.out.println("....Examinig patient...");
        int grade = grading();
        Scanner userChoice = new Scanner(System.in);
        String choice = userChoice.nextLine();
        if(grade >= 5){
            System.out.println("This patient fails to pass the hemorrage grading. With a grading " + grade +", Surgery is needed");
            System.out.println("Do you want a guide for hemorrage? (Yes/No)");
            if(choice == "Yes" || choice == "YES" || choice == "yes"){

            }
        }
        else{
            System.out.println("Fortunately, this patient doesn't have hemorrage.");
        }
        userChoice.close();
    }

    /**
     * 
     */
    public void brainTumor(){
        //Steps of surgery
        // I think tumor is more accessible by everyone so I'm not gonna include the explanation there
        // Draw the "route" of where to open
        // "open" patient's brain
        // Find the brain part that needs surgery
        System.out.println("....Examinig patient...");
        int grade = grading();
        Scanner userChoice = new Scanner(System.in);
        String choice = userChoice.nextLine();
        if(grade >= 5){
            System.out.println("Unfortunately, This patient is tested positive the tumor grading. With a grading " + grade +", Surgery is needed");
            System.out.println("Do you want a guide for hemorrage? (Yes/No)");
            if(choice == "Yes" || choice == "YES" || choice == "yes"){

            }
        }
        else{
            System.out.println("Fortunately, this patient is tested negative in tumor grading. Surgery is not necessary. \nPlease take medicine on time and make another appointment.");
        }
    userChoice.close();

    }

    public static void main(String[] args){ 
        Scanner input = new Scanner(System.in);
        System.out.println("---------Welcome to Surgical Robot Simulator!!!------------");
        System.out.println("In this round, you will use Neurosurgery assistants to perform 3 types of brain surgeries. \n1. Hemorrage \n2. Hematoma \n3.Brain tumor");
        System.out.println("Press 1, 2, or 3 to start with the surgery you want to perform. Press 4 to randomly start the game. Press 5 to quit the game.");
        int surgeryChoice = input.nextInt();
        boolean status = true;
        while(status){
            if(surgeryChoice == 1){
                
            }
            else if(surgeryChoice == 2){

            }
            else if(surgeryChoice == 3){

            }
            else{

            }
        }

    input.close();

    }


}
