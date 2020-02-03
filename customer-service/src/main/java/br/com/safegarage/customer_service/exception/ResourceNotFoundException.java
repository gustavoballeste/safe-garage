package br.com.safegarage.customer_service.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String message;

    public ResourceNotFoundException (final String message) {
        this.message = message;
    }
}
