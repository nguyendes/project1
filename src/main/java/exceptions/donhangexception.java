/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */
public class DonHangException extends RuntimeException {
    // Default constructor
    public DonHangException() {
        super();
    }

    public DonHangException(String message) {
        super(message);
    }

    public DonHangException(String message, Throwable cause) {
        super(message, cause);
    }

    public DonHangException(Throwable cause) {
        super(cause);
    }

    public DonHangException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static DonHangException orderNotFound(String orderId) {
        return new DonHangException("Order not found for order ID: " + orderId);
    }

    public static DonHangException invalidOrder(String details) {
        return new DonHangException("Invalid order: " + details);
    }

    public void logException() {
        System.err.println("Exception occurred: " + this.getMessage());
        this.printStackTrace();
    }
}
