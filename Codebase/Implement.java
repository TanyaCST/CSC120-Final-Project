package Codebase;
public class Implement {
    private boolean isClean;
    private String description;


public Implement(boolean isClean, String desc){
    this.isClean = isClean;
    this.description = desc;
}

public boolean getisClean(){
    return this.isClean;
}

public String getDescription(){
    return this.description;
}

public void setDescription(String desc){
    this.description = desc;
}

public void setisClean(boolean value){
    this.isClean = value;
}

public String toString(){
    return (this.description + " (" + this.isClean + ").");
}
}
