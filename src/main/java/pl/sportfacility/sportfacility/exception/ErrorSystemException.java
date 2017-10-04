package pl.sportfacility.sportfacility.exception;

public class ErrorSystemException extends RuntimeException {

    private final String message;

    public ErrorSystemException(Error fatalError, final String message) {
        super(message);
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
