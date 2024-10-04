package mg.itu.framework.sprint.exception;

public class VerbException extends Exception{
    public VerbException() {
        super("The verb you use is different from the one you use in your method!");
    }
    public VerbException(String message) {
        super(message);
    }
}
