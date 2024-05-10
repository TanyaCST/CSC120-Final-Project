//imports packages
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class BrainRobot extends SurgicalRobot{
    // attributes
    private String name;
    private String patientName;
    ArrayList <Integer> round; // round should be 0 when the game startes
    int restTime = 500;
    Scanner userInput = new Scanner(System.in);
    Scanner userChoice = new Scanner(System.in);
    Random rand = new Random();
    
    /**
     * Constructor
     */
    public BrainRobot(String name, double xCoordinate, double yCoordinate, double size, String patientName){
        super(name, xCoordinate, yCoordinate, size);
        this.name = getName();
        this.patientName = patientName;
        this.round = new ArrayList<Integer>();
        //this.brainParts = brainParts;
    }

    // getters in Brain class
    /**
     * Get patient's name
     */
    public String getPatientName(){
        return this.patientName;
    }

    public ArrayList <Integer> getRound(){
        return round;
    }

    // Methods: showOption, grab, drop, hemorrage, hematoma, tumor
    /**
     * show option in Brain branch
     */
    public void showOptions(){
        System.out.println("For neuro-surgeon" + name + ", it can perform:");
        System.out.println("showOptions() \ngetPatientName() \ngetRound() \ncheckRound() \nchooseSurgery() \ngrading() \nguide() \nhemorrage() \nhematoma() \nbrainTumor()");
    }

    /**
     * Randomly choose from 1-3 and output a number representing a surgery
     * @return a number from 1-3 each represents a surgery
     */
    public int chooseSurgery(){
        int surgeryNum = rand.nextInt(1, 3);
        return surgeryNum;
    }

    /**
     * Randomly generate a grading from 1-10 showing whether the patient needs to do the surgery.
     * @return a numeric grading
     */
    public int grading(){
        int grading = rand.nextInt(1,10);
        return grading;
    }

    /**
     * Provide General guide for all surgeries in Brain robot
     * Users need to be able to input the surgery they want to do
     * Basically, tell users what are equipments needed for each surgery and steps to accomplish the surgeries
     */
    public void guide(){
        // ask for userinput
        System.out.println("This is a guide for Neurosugeries you can perform in this game. Which one do you want to check? \n1. Hemorrage \n2. Hematoma \n3. Brain Tumor");
        System.out.println("If you made a typo, press 4 to quit.");
        int inputInt = userInput.nextInt();

        // based on user choice
        if(inputInt == 1){
            System.out.println("Guide for Hemorrage");

            // show equipments need for hemorrage surgery
            System.out.println("The equipment you will need: forceps, suction tubes, surgical knives, scissors");

            // show treatments for hemorrage surgery
            System.out.println("Treatments:\nDecompression: drill a hole in your skull to drain blood and relieve pressure.\n" + //
                                "Craniectomy: remove a piece of your skull to relieve pressure.\n" + //
                                "Craniotomy: remove and replace a piece of your skull to relieve pressure and manage the source of bleeding");
        }
        else if(inputInt == 2){
            System.out.println("Guide for Hematoma");

            // show equipments need for hematoma surgery
            System.out.println("The equipment you will need: forceps, suction tubes, surgical knives, scissors");

            // show treatments for hematoma surgery
            System.out.println("Treatments:\nCraniotomy: removes a section of  skull to access and remove the hematoma. \nBurr holes: A neurosurgeon drills one or more small holes into your skull to help drain the blood.");
        }
        else if(inputInt == 3){
            System.out.println("Guide for Brain Tumor");

            // show equipments need for brain tumor surgery
            System.out.println("The equipment you will need: forceps, suction tubes, surgical knives, scissors, blue fluorescent light, ultrasound, microscope");

            // show treatments for brain tumor surgery
            System.out.println("Treatment:\nCranitomy: Make a cut in patient's scalp. Uses a drill to cut out a section of skull bone. The brain tumor is cut out with special tools. Sometimes lasers are used to destroy the tumor.");
        }
        else if(inputInt == 4){
            System.out.println("Leaving the guide...");
            System.out.println("Quit");
        }
        else{
            System.out.println("How can you type in a wrong number? I doubt whether you are qualified to be a surgeon.");
        }
    }

    /**
     * check whether users complete 3 surgeries
     * @return
     */
    public boolean checkRound(){
        if(round.size() == 3){
            return true;
        }
        else{
            return false;
        }
    }

    /** 
     * start the hemorrage surgery
     */
    public void hemorrage(BrainRobot newRobot){
        System.out.println("....Examining patient...");

        // check the grading of hemmorage surgery qualification
        int grade = grading();
        if(grade >= 5){
            System.out.println("This patient fails to pass the hemorrage grading. With a grading " + grade +", Surgery is needed");
            System.out.println("Do you want a guide for hemorrage? (Yes/No)");
            String choice = userChoice.nextLine();

            // if needs a guide, show guide
            if(choice.toLowerCase().equals("yes")){
                newRobot.guide();
            }

            boolean doingSurgery = true;
            System.out.println("---------------Surgery starts. Please Grab the equipment you need.----------");
            System.out.println("Here are the equipments you can use.");
            showEquipment();
            String grabEquip = userChoice.nextLine();
            newRobot.grab(grabEquip);
            newRobot.use(grabEquip);

            while(doingSurgery){
                System.out.println("-------Are you done with the surgery? (Yes/No)-------");
                String newChoice = userChoice.nextLine();
                newChoice = newChoice.toLowerCase();
                if(newChoice.equals("yes")){
                    System.out.println("You've completed the surgery");
                    if(survival() == false){
                        System.out.println("You've tried your best to do the surgery, but unfortunately, this patient died. 😢");
                    }
                    else{
                        System.out.println("The surgery is successful! Congradulations!🥳");
                    }
                    doingSurgery = false; 
                }
                else if(newChoice.equals("no")){
                    System.out.println("-------Please grab another equipment.-------");
                    System.out.println("Here are the equipments you can use.");
                    showEquipment();
                    grabEquip = userChoice.nextLine();
                    newRobot.grab(grabEquip);
                    newRobot.use(grabEquip);
                }
                else{
                    System.out.println("?_? I can't believe you typed yes/no wrong.");
                    doingSurgery = false; 
                }
            }
            round.add(1);
            
        }
        else{
            System.out.println("Fortunately, this patient doesn't have hemorrage.");
        }
        
    }

    /**
     * start the hematoma surgery
     */
    public void hematoma(BrainRobot newRobot){
        System.out.println("....Examining patient...");
        int grade = grading();
        if(grade >= 5){
            System.out.println("This patient fails to pass the hematoma grading. With a grading " + grade +", A surgery is needed");
            System.out.println("Do you want a guide for hematoma surgery? (Yes/No)");
            String choice = userChoice.nextLine();
            if(choice.toLowerCase().equals("yes")){
                newRobot.guide();
            }
            boolean doingSurgery = true;
            System.out.println("---------------Surgery starts. Please Grab the equipment you need.----------");
            System.out.println("Here are the equipments you can use.");
            showEquipment();
            String grabEquip = userChoice.nextLine();
            newRobot.grab(grabEquip);
            newRobot.use(grabEquip);

            while(doingSurgery){
                System.out.println("-------Are you done with the surgery? (Yes/No)-------");
                String newChoice = userChoice.nextLine();
                newChoice = newChoice.toLowerCase();
                if(newChoice.equals("yes")){
                    System.out.println("You've completed the surgery");
                    if(survival() == false){
                        System.out.println("You've tried your best to do the surgery, but unfortunately, this patient died. 😢");
                    }
                    else{
                        System.out.println("The surgery is successful! Congradulations!🥳");
                    }
                    doingSurgery = false; 
                }
                else if(newChoice.equals("no")){
                    System.out.println("-------Please grab another equipment.-------");
                    System.out.println("Here are the equipments you can use.");
                    showEquipment();
                    grabEquip = userChoice.nextLine();
                    newRobot.grab(grabEquip);
                    newRobot.use(grabEquip);
                }
                else{
                    System.out.println("?_? I can't believe you typed yes/no wrong.");
                    doingSurgery = false; 
                }
            }
            round.add(2);
            
        }
        else{
            System.out.println("Fortunately, this patient doesn't have hemorrage.");
        }
    }

    /**
     * start the brain tumor surgery
     */
    public void brainTumor(BrainRobot newRobot){
        System.out.println("....Examining patient...");
        int grade = grading();
        if(grade >= 5){
            System.out.println("Unfortunately, This patient is tested positive the tumor grading. With a grading " + grade +", Surgery is needed");
            System.out.println("Do you want a guide for brain tumor surgery? (Yes/No)");
            String choice = userChoice.nextLine();
            if(choice.toLowerCase().equals("yes")){
                newRobot.guide();
            }
            boolean doingSurgery = true;
            System.out.println("---------------Surgery starts. Please Grab the equipment you need.----------");
            System.out.println("Here are the equipments you can use.");
            showEquipment();
            System.out.println("Choose an equipment");
            String grabEquip = userChoice.nextLine();
            newRobot.grab(grabEquip);
            newRobot.use(grabEquip);

            while(doingSurgery){
                System.out.println("-------Are you done with the surgery? (Yes/No)-------");
                String newChoice = userChoice.nextLine();
                newChoice = newChoice.toLowerCase();
                if(newChoice.equals("yes")){
                    System.out.println("You've completed the surgery");
                    if(survival() == false){
                        System.out.println("You've tried your best to do the surgery, but unfortunately, this patient died. 😢");
                    }
                    else{
                        System.out.println("The surgery is successful! Congratulations!🥳");
                    }
                    doingSurgery = false; 
                }
                else if(newChoice.equals("no")){
                    System.out.println("-------Please grab another equipment.-------");
                    System.out.println("Here are the equipments you can use.");
                    showEquipment();
                    grabEquip = userChoice.nextLine();
                    newRobot.grab(grabEquip);
                    newRobot.use(grabEquip);
                }
                else{
                    System.out.println("?_? I can't believe you typed yes/no wrong.");
                    doingSurgery = false; 
                }
            }
            round.add(3);
            
        }
        else{
            System.out.println("Fortunately, this patient is tested negative in tumor grading. Surgery is not necessary. \nPlease take medicine on time and make another appointment.");
        }
    }

    /**
     * To check whether the surgery is successful.
     * @return return true if surgery is successful, false if not
     */
    public boolean survival(){
        if(grading() > 5){
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String[] args){ 
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        // generates a new surgical robot
        BrainRobot newRobot = new BrainRobot("BrainRobot1", 0, 0, 50, "Justin");

        // start the game
        System.out.println("---------Welcome to Surgical Robot Simulator!!!------------");
        System.out.println("In this round, you will use Neurosurgery assistants to perform 3 types of brain surgeries. \n1. Hemorrage \n2. Hematoma \n3. Brain tumor");
        boolean surgeryStatus = true;
        System.out.println("Press 1, 2, or 3 to start with the surgery you want to perform. \nPress 4 to quit the game.");
        int surgeryChoice = input.nextInt();
        String userChoice;

        while(surgeryStatus){
            if(surgeryChoice == 1){
                newRobot.hemorrage(newRobot);
                System.out.println("Do you want to start the next surgery? (YES/NO)");
                input.nextLine();
                userChoice = input.nextLine();

                if(userChoice.toLowerCase().equals("yes")){
                    if(newRobot.getRound().size() != 3){
                        if(newRobot.getRound().contains(2)){
                            surgeryChoice = 3;
                        }
                        else if(newRobot.getRound().contains(3)){
                            surgeryChoice = 2;
                        }
                        else{
                            surgeryChoice = r.nextBoolean() ? 2 : 3;
                        }
                    }
                    else{
                        System.out.println("You have finished all the surgeries :))))))");
                        surgeryChoice = 4;
                    }
                   
                }
                else{
                    surgeryChoice = 4;
                }    
                
            }
            else if(surgeryChoice == 2){
                newRobot.hematoma(newRobot);

                System.out.println("Do you want to start the next surgery? (YES/NO)");
                input.nextLine();
                userChoice = input.nextLine();
                
                if(userChoice.toLowerCase().equals("yes")){
                    if(newRobot.getRound().size() != 3){
                        if(newRobot.getRound().contains(1)){
                            surgeryChoice = 3;
                        }
                        else if(newRobot.getRound().contains(3)){
                            surgeryChoice = 1;
                        }
                        else{
                            surgeryChoice = r.nextBoolean() ? 1 : 3;
                        }
                    }
                    else{
                        System.out.println("You have finished all the surgeries :))))))");
                        surgeryChoice = 4;
                    }
                   
                }
                else{
                    surgeryChoice = 4;
                }    
                
            }
            else if(surgeryChoice == 3){
                newRobot.brainTumor(newRobot);
                System.out.println("Do you want to start the next surgery? (YES/NO)");
                input.nextLine();
                userChoice = input.nextLine();
                
                if(userChoice.toLowerCase().equals("yes")){
                    if(newRobot.getRound().size() != 3){
                        if(newRobot.getRound().contains(2)){
                            surgeryChoice = 1;
                        }
                        else if(newRobot.getRound().contains(1)){
                            surgeryChoice = 2;
                        }
                        else{
                            surgeryChoice = r.nextBoolean() ? 1 : 2;
                        }
                    }
                    else{
                        System.out.println("You have finished all the surgeries :))))))");
                        surgeryChoice = 4;
                    }
                   
                }
                else{
                    surgeryChoice = 4;
                } 
                
            }
            else if(surgeryChoice == 4){
                System.out.println("You are leaving Neuro-Surgical Robots simulator........ Bye:))))))");
                surgeryStatus = false;
                
            }
            else{
                System.out.println("I don't think you are qualified if you can't type in a number correctly :/");
                surgeryStatus = false;
                
            }
        }

    input.close();

    }

}
