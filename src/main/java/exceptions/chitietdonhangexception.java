/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */

public class ChiTietDonHangException extends RuntimeException {
    public ChiTietDonHangException() {
        super();
    }

    public ChiTietDonHangException(String message) {
        super(message);
    }

    public ChiTietDonHangException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChiTietDonHangException(Throwable cause) {
        super(cause);
    }

    public ChiTietDonHangException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static ChiTietDonHangException invalidOrderDetails(String details) {
        return new ChiTietDonHangException("Invalid order details: " + details);
    }

    public static ChiTietDonHangException orderDetailsNotFound(String orderId) {
        return new ChiTietDonHangException("Order details not found for order ID: " + orderId);
    }

    public void logException() {
        System.err.println("Exception occurred: " + this.getMessage());
        this.printStackTrace();
    }
}
