
//Not all robot classes makes use of the implement class, but the superclass, and brain robots do.
public class Implement {
    private boolean isClean;
    private String description;


/**
 * Constructor; initializes the isClean and description of the associated equipment
 * @param isClean
 * @param desc
 */
public Implement(boolean isClean, String desc){
    this.isClean = isClean;
    this.description = desc;
}

/**
 * Getter for disinfect nature of equipment
 * @return
 */
public boolean getisClean(){
    return this.isClean;
}

/**
 * Getter for equipment's description
 * @return
 */
public String getDescription(){
    return this.description;
}

/**
 * setter for equipment's description
 * @param desc
 */
public void setDescription(String desc){
    this.description = desc;
}

/**
 * setter for isClean value
 * @param value
 */
public void setisClean(boolean value){
    this.isClean = value;
}

public String toString(){
    return (this.description + " (" + this.isClean + ").");
}
}
