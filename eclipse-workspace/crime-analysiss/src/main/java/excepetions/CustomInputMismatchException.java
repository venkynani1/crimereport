package excepetions;

public class CustomInputMismatchException extends Exception {

    // Constructor to create exception with custom message
    public CustomInputMismatchException(String message) {
        super(message);
    }

    // Constructor to create exception with custom message and cause
    public CustomInputMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
