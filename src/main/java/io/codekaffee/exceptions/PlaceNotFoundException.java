package io.codekaffee.exceptions;

public class PlaceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public PlaceNotFoundException() {
        super("Error: Ponto Turistico não encontrado");
    }

    /**
     * @param message
     */
    public PlaceNotFoundException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public PlaceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    
    
}
