package org.example.payment_platform.exceptions;

public class CurrencyMismatchException extends RuntimeException {
    public CurrencyMismatchException(String message) {
        super(message);
    }
}
