//Import needed modules
import java.util.Hashtable; 
import java.util.Stack;

import javax.sound.midi.Soundbank;

import java.util.Scanner;

public class SurgicalRobot implements Contract{

    //Made attributes private because I don't want random strangers ordering my robot around. Can be harmful to the company's security.
    private String name; //Name of SurgicalRobot
    private double x; //Location of Robot (x, y)
    private double y;
    private double size; //Specifies robot's size
    private double originalSize;
    private Stack<String> actions = new Stack<>();//Undo: Plan on appending each method. What do I pass in, not possibly a string? A method?
    public String currentState; //Sets the currentState of the robot
    public Hashtable<String, String> functions; //allows surgeon to add new functions
    Scanner input = new Scanner(System.in); //reads input from the surgeon
    int active = 1; //Sets active state of robot to 1, meaning awake, once created.

    
    /**
     * Constructor for SurgicalRobot Class--- initializes attributes
     * @param name
     * @param x
     * @param y
     * @param size
     */
    public SurgicalRobot(String name, double x, double y, double size){
        this.name = name;
        //Is it possible to do (x, y) instead?
        this.x = x;
        this.y = y;
        this.size = size;
        this.originalSize = this.size; //Preserves size entered by user incase of resizing (157-162)
        this.functions = new Hashtable<String, String>();
    }

    // Do it again because of merge issue
    //Getters and Setters
    /**
     * get name of robot
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * get x coordinate of robot
     * @return
     */
    public double getX(){
        return x;
    }

    /**
     * get y coordinate of robot
     * @return
     */
    public double getY(){
        return y;
    }


    /**
     * get robot's size
     * @return
     */
    public double getSize(){
        return size;
    }

    /**
     * get robot's original size
     * @return
     */
    public double getOriginalSize(){
        return originalSize;
    }

    /**
     * get
     * @return
     */
    public Stack<String> getActions(){
        return actions;
    }

    /**
     * get current state of robot
     * @return
     */
    public String getCurrentState(){
        return currentState;
    }

    /**
     * get inventory
     * @return
     */
    public Hashtable<String,String> getFunctions(){
        return functions;
    }

    /**
     * get active (a number that tells you is the robot active or not)
     * @return
     */
    public int active(){
        return active;
    }

    //methods
    /**
     * Writes the action performed to "memory"
     * @param item
     */
    private void performAction(String item){
        currentState = item;
        actions.push(item); //Adds item to Stack "actions"
        }

    //Undoes the last action in "memory"
    public void undo(){
        if (!actions.isEmpty()){
            String lastAction = actions.pop();
            System.out.println(" Undoing " + lastAction + " ");

        }
    }
    //Redo the last action in memory
    public void redo(){
        //Fill in at some point
    }

    /**
     * Adds a tool and its functions
     * @param tool
     * @param function
     */
    private void addFunction(String tool, String function){
        this.functions.put(tool, function);
    }
  /**
     * Grabs item
     * @param item
     */
    public void grab(String item){ //Says function of object in canneddList
        System.out.println("I just grabbed the " + item);
        rest(1000);
        performAction("Grab");
        //Checks if item is in list of functions and shows function if available.
        //Can make doctor say its function if not there
        if (this.functions.containsKey(item)){
            System.out.println(this.functions.get(item));
        }
        else{
            System.out.println("Do you want to add the function of " + item + " to the library?\nEnter Yes or No");
            String operator = input.nextLine();
            rest(1000); //Delays the program for 1s
            if (operator.toLowerCase().equals("yes")){
                //Ask doctor for function using scanner
                System.out.println("What's the function of " + item + "? Start with they are or it is");
                operator = input.nextLine();
                //Adds function to hashtable of functions
                this.functions.put(item, operator);
                rest(1000);
                System.out.println("Added!");
            }
            else if(operator.toLowerCase().equals("no")){
                rest(1000);
                System.out.println("Okay. Call .addFunction() whenever you want to add the function of " + item + " to the library.");
            }
            else{
                rest(1000);
                System.out.println("I didn't quite get that.");
        }
    }
}
  /**
     * Drops an item
     * @param tool
     * @param function
     */   
    public String drop(String item){
        performAction("Drop!");
        System.out.println("I just dropped the " + item);
        return("I just dropped the " + item);}
  /**
     * Examines an item
     * @param tool
     * @param function
     */   
    public void examine(String item){
        //Default response after examining item
        String examine = ("Examining " + item + ".....\n" + item + " is a surgical equipment. " );
        performAction("Examine");
        //Checks for additional functionality
        if (this.functions.containsKey(item)){
            examine += this.functions.get(item);
        }
        System.out.println(examine);}
  /**
     * Uses an item
     * @param tool
     * @param function
     */   
    public void use(String item){
        System.out.println(".........What do you want me to do with " + item + "?.........\n.........Start with to in your response............");
        String operator = input.nextLine().toLowerCase();
        System.out.println("Gotcha!\nUsing " + item + " " + operator); //what if  "I want you to ?"
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
    public boolean walk(double x, double y){
        try {
            System.out.println("Changed position! At the coordinate (" + x + "," + y + ").");
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
    public boolean fly(int x, int y){ //Move x m and ym
        try{
        System.out.println("----------Flyinggg!!! I love flying. It makes me refreshed.--------");
        this.x += x; this.y += y;
        System.out.println("At (" + this.x + "," + this.y + "). Yepeee");
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
        while (OlohIntel.input.nextLine().toLowerCase().equals("no")){ //Doesn't allow program to proceed if user doesn't agree to see options
            System.out.println("Enter YES to proceed. You can't use me without seeing my options");// Question: I would love to allow the user quit using quit(). How do I implement that?
        }    
        OlohIntel.showOptions();
        OlohIntel.rest(1000); //Pauses program for 1s ot make it more real
        System.out.println("I'mma grab an equipment to start work. What equipment do you want to use?");
        String equipment = OlohIntel.input.nextLine(); //Passes equipment to be used to the variable equipment
        OlohIntel.rest(1000);
        OlohIntel.grab(equipment); //Implements grab method
        OlohIntel.rest(1000);
        System.out.println("--------Let's start by examining " + equipment + "---------");
        OlohIntel.rest(1000);
        OlohIntel.examine(equipment); //Implements examine method
        //OlohIntel.drop("forceps"); Add to the end of the code
        OlohIntel.rest(1000);
        System.out.println("Confirm you want to use OlohIntel in the surgery.....\nYES OR NO");
        String use = OlohIntel.input.nextLine().toLowerCase(); //use as a unique varaible to store user's response in preparation for invoking the use() method
        if (use.equals("no")){
            OlohIntel.rest(1000);
            System.out.println("Okay, bye!");}

        else{
            OlohIntel.rest(1000);
            OlohIntel.use(equipment); //Implements the use() method
            System.out.println("--------------------------");
            OlohIntel.rest(1000);
            System.out.println("OlohIntel needs to walk to perform her function\nShould she walk in a specific cardinal direction or according to a coordinate?\n............Enter Cardinal or Coordinate");
            String walkType = OlohIntel.input.nextLine().toLowerCase(); //Unique variable to store user's response in prep for invoking the walk() method
            OlohIntel.rest(1000);
            while (!(walkType.equals("cardinal") | walkType.equals("coordinate"))){
                System.out.println("Cardinal or Coordinate? Reenter!");} //Allows user to select which of the overloaded methods to use
                if (walkType.equals("cardinal")){  
                    //Runs if user prefers cardinal directions
                    System.out.println("Enter direction: right/left/forward/backward");
                    String direction = OlohIntel.input.nextLine().toLowerCase();
                    OlohIntel.rest(1000);
                    OlohIntel.walk(direction);
                    System.out.println("--------------------------");}
                else if ((walkType.equals("coordinate"))){ 
                    //Runs if user prefers coordinate directions
                    System.out.println("Enter x coordinate"); 
                    double x = OlohIntel.input.nextInt();
                    OlohIntel.rest(1000);
                    System.out.println("Enter y coordinate");
                    double y = OlohIntel.input.nextInt();
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

