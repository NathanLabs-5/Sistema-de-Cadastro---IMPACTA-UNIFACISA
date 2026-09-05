package exceptions;

public class AcaoNaoEncontrada extends RuntimeException {
    public AcaoNaoEncontrada(String message) {
        super(message);
    }
}
