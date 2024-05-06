package Codebase;
public interface Contract {

    void grab(String equipment);
    String drop(String equipment);
    void examine(String equipment);
    void use(String equipment);
    boolean walk(String direction);
    boolean fly(int x, int y);
    Number shrink();
    Number grow();
    void rest();
    void undo();

}