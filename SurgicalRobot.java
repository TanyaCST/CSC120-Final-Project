//Import needed modules
import java.util.ArrayList;
import java.util.Hashtable; 
import java.util.Stack;

import javax.sound.midi.Soundbank;

import java.util.Scanner;

public class SurgicalRobot implements Contract{

    //Made attributes private because I don't want random strangers ordering my robot around. Can be harmful to the company's security.
    private String name; //Name of SurgicalRobot
    private double xCoordinate; //Location of Robot (x, y)
    private double yCoordinate;
    private double size; //Specifies robot's size
    private double originalSize;
    private Stack<String> actions = new Stack<>();//Undo: Plan on appending each method. What do I pass in, not possibly a string? A method?
    public String currentState; //Sets the currentState of the robot
    public Hashtable<String, Implement> inventory; //inventory with functions
    Scanner readEquipment = new Scanner("equipments.txt"); //Reads allowable equipment from equipment file
    Scanner userInput = new Scanner(System.in); //reads input from the surgeon
    int active = 1; //Sets active state of robot to 1, meaning awake, once created.

    
    /**
     * Constructor for SurgicalRobot Class--- initializes attributes
     * @param name
     * @param x
     * @param y
     * @param size
     */
    public SurgicalRobot(String name, double xCoordinate, double yCoordinate, double size){
        this.name = name;
        //Is it possible to do (x, y) instead?
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.size = size;
        this.originalSize = this.size; //Preserves size entered by user incase of resizing (157-162)
        this.inventory = new Hashtable<String, String>();
    }

    /**
     * Writes the action performed to "memory"
     * @param item
     */
    private void performAction(String item){
        currentState = item;
        actions.push(item); //Adds equipment to Stack "actions"
        }

    //Undoes the last action in "memory"
    //Would like to be able to grab and drop by the way--- kinda like inverse options
    public void undo(){ 
        if (!actions.isEmpty()){
            String lastAction = actions.peek();
            System.out.println("Sorry, in surgery, mistakes aren't permittable! Cannot undo " + lastAction + ". Be careful next time");

        }
    }

    /**
     * Adds a tool and its functions
     * @param equipment
     * @param function
     */
    private void addDescription(String equipment, String description){
        this.inventory.put(equipment, description);
        //this.functions.put(equipment, disinfect);
    }

  /**
     * Grabs equipment
     * @param equipment
     */
    public void grab(String equipment){ //Says function of object in canneddList
        if (this.inventory.containsKey(equipment)){
            String function =  this.inventory.get(equipment);
            System.out.println("I just grabbed " + equipment + "./n" + function);
            performAction("grab");
        }
        //Need an inventory to have a static list of equipments to pick from
        //else()
        System.out.println("I just grabbed the " + equipment);
        rest(1000);
        performAction("Grab");
        //Checks if equipment is in list of functions and shows function if available.
        //Can make surgeon say its function if not there
        if (this.inventory.containsKey(equipment)){
            System.out.println(this.inventory.get(equipment));
        }
        else{
            System.out.println("Do you want to add the function of " + equipment + " to the library?\nEnter Yes or No");
            String operator = userInput.nextLine();
            rest(1000); //Delays the program for 1s
            if (operator.toLowerCase().equals("yes")){
                //Ask doctor for function using scanner
                System.out.println("What's the function of " + equipment + "? Start with they are or it is");
                operator = userInput.nextLine();
                //Adds function to hashtable of functions
                this.inventory.put(equipment, operator);
                rest(1000);
                System.out.println("Added!");
            }
            else if(operator.toLowerCase().equals("no")){
                rest(1000);
                System.out.println("Okay. Call .addFunction() whenever you want to add the function of " + equipment + " to the library.");
            }
            else{
                rest(1000);
                System.out.println("I didn't quite get that.");
        }
    }
}
  /**
     * Drops an equipment
     * @param tool
     * @param function
     */   
    public String drop(String equipment){
        performAction("Drop!");
        System.out.println("I just dropped the " + equipment);
        return("I just dropped the " + equipment);}
  /**
     * Examines an equipment
     * @param tool
     * @param function
     */   
    public void examine(String equipment){
        //Default response after examining equipment
        String examine = ("Examining " + equipment + ".....\n" + equipment + " is a surgical equipment. " );
        performAction("Examine");
        //Checks for additional functionality
        if (this.inventory.containsKey(equipment)){
            examine += this.inventory.get(equipment);
        }
        System.out.println(examine);}
  /**
     * Uses an equipment
     * @param tool
     * @param function
     */   
    public void use(String equipment){
        System.out.println(".........What do you want me to do with " + equipment + "?.........\n.........Start with to in your response............");
        String operator = userInput.nextLine().toLowerCase();
        System.out.println("Gotcha!\nUsing " + equipment + " " + operator); //what if  "I want you to ?"
        performAction("Use");//writes to memory
    }
    /**
     * Default walk method for direction to right, left, forward, backward
     * @param direction
     * @return true or false
     */
    public boolean walk(String direction){ 
        try {
            System.out.println(this.name + " is moving in the " + direction + " direction");
            performAction("Walk");
            return true; //Tentative. Haven't actually moved.    
        } catch (Exception e) {
            System.out.println("Not valid");
            return false;
        }
       
    }
    /**
     * Walk to a specific cardinal point-- Overloaded 
     * @param x
     * @param y
     * @return
     */
    public boolean walk(double xCoordinate, double yCoordinate){
        try {
            System.out.println("Changed position! At the coordinate (" + xCoordinate + "," + yCoordinate + ").");
            performAction("Walk");
            return true; //Tentative. Haven't actually moved.    
        } catch (Exception e) {
            return false;
        }
       
    }
    /**
     * Walk to a specific cardinal point-- Overloaded 
     * @param x
     * @param y
     * @return
     */
    public boolean fly(int xCoordinate, int yCoordinate){ //Move x m and ym
        try{
        System.out.println("----------Flyinggg!!! I love flying. It makes me refreshed.--------");
        this.xCoordinate += xCoordinate; this.yCoordinate += yCoordinate;
        System.out.println("At (" + this.xCoordinate + "," + this.yCoordinate + "). Yepeee");
        performAction("Fly");
        return true;
    }
        catch(Exception e){
            return false;
        }}
    /**
     * Reduces size of robot
     * @return this.size
     */
    public Number shrink(){
        System.out.println("------------Shrinking by a factor of " + 2 + "fts.--------------");
        this.size = this.size / 2;
        System.out.println("I am now " + this.size + " feets tall\nPlease don't bully me🥲.");
        performAction("Shrink");
        return this.size;
    }
    /**
     * Increases size of robot
     * @return this.size
     */
    public Number grow(){ 
        System.out.println("Growing by a factor of " + 3);
        this.size = this.size * 3;
        System.out.println("I am now " + this.size + " feets tall😃\n" + "Can you grow that fast haha?😂");
        performAction("Grow");
        return this.size;

    }

    /**
     * Resets size of robot
     * @return this.size
     */
    public Number resetSize(){
        System.out.println("......Resetting size......\nBack to " + this.originalSize + "fts");
        performAction("Reset size");
        //Sets this.size to original value entered by user
        this.size = this.originalSize;
        return this.size; //Use another variable or hard code
    }
    
    /**
     * Lays robot to rest
     */
    public void rest(){
        if (active == 1){ //Checks if robot is awake
        active = 0; //0 for rest mode
        System.out.println("................." + this.name + " is currently inactive...............");
        performAction("Rest!");}
        else{
            throw new RuntimeException(this.name + "already at rest. Must invoke .wake() to use this method");
        }
    }

    public void rest(int sec){
        try {
            Thread.sleep(sec);
        } catch (Exception e) {
            System.err.println("InterruptedError Exception while at rest. Will resume work in a ");
        }
    }
    /**
     * Wakes robot from rest
     */
    public void wake(){
        if (active == 0){
        active = 1;
        System.out.println(this.name + " is now active and ready to work.");
        }
        else{
            throw new RuntimeException(this.name + "already awake. Must invoke .rest() to use this method");
        }
    }

    /**
     * Reveals the tasks the robot can perform
     */
    public void showOptions(){
        rest(1000);
        System.out.println(this.name + " can perform the following functions:");
        rest(1000);
        System.out.println("\ngrab()\ndrop()\nexamine()\nuse()\nwalk()\nfly()\nshrink()\ngrow()\nresetSize()\nrest()\nwake()\nshowOptions()\n");
    }

    public String toString(){
       return("I am " + this.name + ", a surgical assistant " + this.size + " fts tall.\nHow can I help you? Use the showOptions method to see what I can assist with." );
    }

    public static void main(String[] args) {
        SurgicalRobot OlohIntel = new SurgicalRobot("OlohIntel", 0, 0, 50);
        System.out.println(OlohIntel); //Prints out robot's description
        System.out.println(); //Prints an empty line
        System.out.println("Do you want to invoke the showOptions?: Enter Yes or No");
        while (OlohIntel.userInput.nextLine().toLowerCase().equals("no")){ //Doesn't allow program to proceed if user doesn't agree to see options
            System.out.println("Enter YES to proceed. You can't use me without seeing my options");// Question: I would love to allow the user quit using quit(). How do I implement that?
        }    
        OlohIntel.showOptions();
        OlohIntel.rest(1000); //Pauses program for 1s ot make it more real
        System.out.println("I'mma grab an equipment to start work. What equipment do you want to use?");
        String equipment = OlohIntel.userInput.nextLine(); //Passes equipment to be used to the variable equipment
        OlohIntel.rest(1000);
        OlohIntel.grab(equipment); //Implements grab method
        OlohIntel.rest(1000);
        System.out.println("--------Let's start by examining " + equipment + "---------");
        OlohIntel.rest(1000);
        OlohIntel.examine(equipment); //Implements examine method
        //OlohIntel.drop("forceps"); Add to the end of the code
        OlohIntel.rest(1000);
        System.out.println("Confirm you want to use OlohIntel in the surgery.....\nYES OR NO");
        String use = OlohIntel.userInput.nextLine().toLowerCase(); //use as a unique varaible to store user's response in preparation for invoking the use() method
        if (use.equals("no")){
            OlohIntel.rest(1000);
            System.out.println("Okay, bye!");}

        else{
            OlohIntel.rest(1000);
            OlohIntel.use(equipment); //Implements the use() method
            System.out.println("--------------------------");
            OlohIntel.rest(1000);
            System.out.println("OlohIntel needs to walk to perform her function\nShould she walk in a specific cardinal direction or according to a coordinate?\n............Enter Cardinal or Coordinate");
            String walkType = OlohIntel.userInput.nextLine().toLowerCase(); //Unique variable to store user's response in prep for invoking the walk() method
            OlohIntel.rest(1000);
            while (!(walkType.equals("cardinal") | walkType.equals("coordinate"))){
                System.out.println("Cardinal or Coordinate? Reenter!");} //Allows user to select which of the overloaded methods to use
                if (walkType.equals("cardinal")){  
                    //Runs if user prefers cardinal directions
                    System.out.println("Enter direction: right/left/forward/backward");
                    String direction = OlohIntel.userInput.nextLine().toLowerCase();
                    OlohIntel.rest(1000);
                    OlohIntel.walk(direction);
                    System.out.println("--------------------------");}
                else if ((walkType.equals("coordinate"))){ 
                    //Runs if user prefers coordinate directions
                    System.out.println("Enter x coordinate"); 
                    double x = OlohIntel.userInput.nextInt();
                    OlohIntel.rest(1000);
                    System.out.println("Enter y coordinate");
                    double y = OlohIntel.userInput.nextInt();
                    OlohIntel.rest(1000);
                    OlohIntel.walk(x, y); }}
        //Will invoke these in my game
        
        // OlohIntel.fly(5, 5); //Will invoke these in my game
        // OlohIntel.shrink();
        // OlohIntel.grow();
        // OlohIntel.resetSize();
        // OlohIntel.rest();
        // OlohIntel.wake();
        
        //System.out.println(OlohIntel.actions);
//         OlohIntel.undo();
//         OlohIntel.rest();
//         OlohIntel.fly(2,3);
        }


}

