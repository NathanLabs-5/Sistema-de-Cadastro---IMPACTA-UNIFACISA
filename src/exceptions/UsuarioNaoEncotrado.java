package exceptions;

public class UsuarioNaoEncotrado extends RuntimeException {
    public UsuarioNaoEncotrado(String message) {
        super(message);
    }
}
