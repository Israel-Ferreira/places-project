package io.codekaffee.exceptions;

public class EmptyArgumentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public EmptyArgumentException() {
        super("Erro: Argumento Vazio ou Nulo");
    }

    /**
     * @param message
     */
    public EmptyArgumentException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public EmptyArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    
    
}
