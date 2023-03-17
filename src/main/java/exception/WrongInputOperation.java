package exception;

public class WrongInputOperation extends RuntimeException {
    public WrongInputOperation(String message) {
        super(message);
    }
}