import java.util.Random;
import java.util.Scanner;

public class Brain extends SurgicalRobot{
    // attributes
    private String name;
    private String patientName;
    int round = 0;
    
    /**
     * Constructor
     */
    public Brain(String name, double xCoordinate, double yCoordinate, double size, String patientName){
        super(name, xCoordinate, yCoordinate, size);
        this.name = getName();
        this.patientName = patientName;
        //this.brainParts = brainParts;
    }

    // getters in Brain class
    /**
     * 
     */
    public String getPatientName(){
        return this.patientName;
    }

    public int getRound(){
        return round;
    }

    // Methods: showOption, grab, drop, hemorrage, hematoma, tumor
    /**
     * 
     */
    public void showOptions(){
        System.out.println("For neuro-surgeron" + name + ", it can perform:");
        System.out.println("showOptions() \ngetPatientName() \ngetRound() \ncheckRound() \nchooseSurgery() \ngrading() \nguide() \nhemorrage() \nhematoma() \nbrainTumor()");
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
        System.out.println("This is a guide for Neurosugeries you can perform in this game. Which one do you want to check? \n1. Hemorrage \n2. Hematoma \n3. Brain Tumor");
        System.out.println("If you made a typo, press 4 to quit.");
        int inputInt = userInput.nextInt();
        if(inputInt == 1){
            System.out.println("Guide for Hemorrage");
            System.out.println("The equipment you will need: forceps, suction tubes, surgical knives");
            System.out.println("Treatments:\n1.Remove skull to relief the pressure");
        }
        else if(inputInt == 2){
            System.out.println("Guide for Hematoma");
            System.out.println("The equipment you will need: forceps, suction tubes, surgical knives");
            System.out.println("Treatments:\n1. Remove part of skull that trigger hematoma\n2. Drill a hole\n3. Remove and replace a piece of skull");
        }
        else if(inputInt == 3){
            System.out.println("Guide for Brain Tumor");
            System.out.println("The equipment you will need: forceps, suction tubes, surgical knives");
        }
        else if(inputInt == 4){
            System.out.println("Leaving the guide...");
            System.out.println("Quit");
        }
        else{
            System.out.println("How can you type in a wrong number? I'll quit.");
        }
    }

    public boolean checkRound(){
        if (round == 3){
            return true;
        }
        else{
            return false;
        }
    }

    /** 
     * 
     */
    public void hemorrage(Brain newRobot){
        System.out.println("....Examinig patient...");
        int grade = grading();
        Scanner userChoice = new Scanner(System.in);
        if(grade >= 5){
            System.out.println("This patient fails to pass the hemorrage grading. With a grading " + grade +", Surgery is needed");
            System.out.println("Do you want a guide for hemorrage? (Yes/No)");
            String choice = userChoice.nextLine();
            if(choice.toLowerCase().equals("yes")){
                newRobot.guide();
            }
            boolean doingSurgery = true;
            System.out.println("Surgery starts. Please Grab the equipment you need.");
            String grabEquip = userChoice.nextLine();
            newRobot.grab(grabEquip);
            newRobot.use(grabEquip);

            while(doingSurgery){
                System.out.println("Are you done with the surgery? (Yes/No)");
                String newChoice = userChoice.nextLine();
                newChoice = newChoice.toLowerCase();
                if(newChoice.equals("yes")){
                    System.out.println("You've completed the surgery");
                    doingSurgery = false;
                }
                else if(newChoice.equals("no")){
                    System.out.println("Please grab another equipment.");
                    grabEquip = userChoice.nextLine();
                    newRobot.grab(grabEquip);
                    newRobot.use(grabEquip);
                }
                else{
                    System.out.println("Please enter yes or no");
                }
            }
            round += 1;
            userChoice.close();
        }
        else{
            System.out.println("Fortunately, this patient doesn't have hemorrage.");
        }
        userChoice.close();
    }

    /**
     * 
     */
    public void hematoma(Brain newRobot){
        System.out.println("....Examinig patient...");
        int grade = grading();
        Scanner userChoice = new Scanner(System.in);
        if(grade >= 5){
            System.out.println("This patient fails to pass the hematoma grading. With a grading " + grade +", A surgery is needed");
            System.out.println("Do you want a guide for hematoma surgery? (Yes/No)");
            String choice = userChoice.nextLine();
            if(choice.toLowerCase().equals("yes")){
                newRobot.guide();
            }
            boolean doingSurgery = true;
            System.out.println("Surgery starts. Please Grab the equipment you need.");
            String grabEquip = userChoice.nextLine();
            newRobot.grab(grabEquip);
            newRobot.use(grabEquip);

            while(doingSurgery){
                System.out.println("Are you done with the surgery? (Yes/No)");
                String newChoice = userChoice.nextLine();
                newChoice = newChoice.toLowerCase();
                if(newChoice.equals("yes")){
                    System.out.println("You've completed the surgery");
                    userChoice.close();
                    doingSurgery = false;
                }
                else if(newChoice.equals("no")){
                    System.out.println("Please grab another equipment.");
                    grabEquip = userChoice.nextLine();
                    newRobot.grab(grabEquip);
                    newRobot.use(grabEquip);
                }
                else{
                    System.out.println("Please enter yes or no");
                }
            }
            round += 1;
        }
        else{
            System.out.println("Fortunately, this patient doesn't have hemorrage.");
        }
    }

    /**
     * 
     */
    public void brainTumor(Brain newRobot){
        System.out.println("....Examinig patient...");
        int grade = grading();
        if(grade >= 5){
            System.out.println("Unfortunately, This patient is tested positive the tumor grading. With a grading " + grade +", Surgery is needed");
            System.out.println("Do you want a guide for brain tumor surgery? (Yes/No)");
            Scanner userChoice = new Scanner(System.in);
            String choice = userChoice.nextLine();
            if(choice.toLowerCase().equals("yes")){
                newRobot.guide();
            }
            boolean doingSurgery = true;
            System.out.println("Surgery starts. Please Grab the equipment you need.");
            String grabEquip = userChoice.nextLine();
            newRobot.grab(grabEquip);
            newRobot.use(grabEquip);

            while(doingSurgery){
                System.out.println("Are you done with the surgery? (Yes/No)");
                String newChoice = userChoice.nextLine();
                newChoice = newChoice.toLowerCase();
                if(newChoice.equals("yes")){
                    System.out.println("You've completed the surgery");
                    doingSurgery = false;
                }
                else if(newChoice.equals("no")){
                    System.out.println("Please grab another equipment.");
                    grabEquip = userChoice.nextLine();
                    newRobot.grab(grabEquip);
                    newRobot.use(grabEquip);
                }
                else{
                    System.out.println("Please enter yes or no");
                }
            }
            round += 1;
            userChoice.close();
        }
        else{
            System.out.println("Fortunately, this patient is tested negative in tumor grading. Surgery is not necessary. \nPlease take medicine on time and make another appointment.");
        }
    }

    public static void main(String[] args){ 
        Scanner input = new Scanner(System.in);
        Brain newRobot = new Brain("BrainRobot1", 0, 0, 50, "Justin");
        System.out.println("---------Welcome to Surgical Robot Simulator!!!------------");
        System.out.println("In this round, you will use Neurosurgery assistants to perform 3 types of brain surgeries. \n1. Hemorrage \n2. Hematoma \n3. Brain tumor");
        System.out.println("Press 1, 2, or 3 to start with the surgery you want to perform. \nPress 4 to randomly start the game. \nPress 5 to quit the game.");
        int surgeryChoice = input.nextInt();
        boolean surgeryStatus = true;
        while(surgeryStatus){
            if(surgeryChoice == 1){
                newRobot.hemorrage(newRobot);
                if(newRobot.checkRound() == true){
                    System.out.println("You have completed all surgeries! Well Done!");
                    surgeryStatus = false;
                }
            }
            else if(surgeryChoice == 2){
                newRobot.hematoma(newRobot);
                if(newRobot.checkRound() == true){
                    System.out.println("You have completed all surgeries! Well Done!");
                    surgeryStatus = false;
                }
            }
            else if(surgeryChoice == 3){
                newRobot.brainTumor(newRobot);
                if(newRobot.checkRound() == true){
                    System.out.println("You have completed all surgeries! Well Done!");
                    surgeryStatus = false;
                }
            }
            else if(surgeryChoice == 4){
                surgeryChoice = newRobot.chooseSurgery();
            }
            else if(surgeryChoice == 5){
                System.out.println("You are leaving Neuro-Surgical Robots simulator........ Bye!");
                surgeryStatus = false;
            }
            else{
                System.out.println("Please enter a number between 1 to 5");
            }
        }

    input.close();

    }
    

}
