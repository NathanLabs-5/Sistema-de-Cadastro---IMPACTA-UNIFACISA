package exceptions;

public class AcaoLotada extends RuntimeException {
    public AcaoLotada(String message) {
        super(message);
    }
}
