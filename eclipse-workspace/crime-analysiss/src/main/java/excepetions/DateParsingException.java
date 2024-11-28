package excepetions;

public class DateParsingException extends Exception {

    // Constructor that accepts a message
    public DateParsingException(String message) {
        super(message);
    }

    // Constructor that accepts both a message and a cause
    public DateParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
