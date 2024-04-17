public class Implement {
    boolean isClean;
    String description;


public Implement(boolean isClean, String desc){
    this.isClean = isClean;
    this.description = desc;
}

public String toString(){
    return (this.description + " (" + this.isClean + ").");
}
}
