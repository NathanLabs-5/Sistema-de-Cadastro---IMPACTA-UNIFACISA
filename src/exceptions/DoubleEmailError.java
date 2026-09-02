package exceptions;

public class DoubleEmailError extends RuntimeException {
    public DoubleEmailError(String message) {
        super(message);
    }
}
