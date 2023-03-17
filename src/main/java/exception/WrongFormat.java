package exception;

public class WrongFormat extends RuntimeException {
    public WrongFormat(String message) {
        super(message);
    }
}