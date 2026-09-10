package exceptions;

public class AcaoNaoEncontrada extends IllegalArgumentException {
    public AcaoNaoEncontrada(String message) {
        super(message);
    }
}
