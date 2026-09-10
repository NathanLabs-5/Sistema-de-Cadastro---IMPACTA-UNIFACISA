package exceptions;

public class UsuarioNaoEncontrado extends IllegalArgumentException {
    public UsuarioNaoEncontrado(String message) {
        super(message);
    }
}
