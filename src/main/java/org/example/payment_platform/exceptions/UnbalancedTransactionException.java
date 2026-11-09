package org.example.payment_platform.exceptions;

public class UnbalancedTransactionException extends RuntimeException {
    public UnbalancedTransactionException(String message) {
        super(message);
    }
}
