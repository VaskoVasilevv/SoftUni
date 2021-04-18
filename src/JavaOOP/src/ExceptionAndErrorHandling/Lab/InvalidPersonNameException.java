package ExceptionAndErrorHandling.Lab;

public class InvalidPersonNameException extends RuntimeException{
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
