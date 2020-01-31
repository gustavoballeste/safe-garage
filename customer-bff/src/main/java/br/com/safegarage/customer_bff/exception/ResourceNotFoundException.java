package br.com.safegarage.customer_bff.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String message;

    public ResourceNotFoundException (final String message) {
        this.message = message;
    }
}
