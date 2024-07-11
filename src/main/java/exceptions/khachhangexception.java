/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */
public class KhachHangException extends RuntimeException {

    public KhachHangException() {
        super();
    }

    public KhachHangException(String message) {
        super(message);
    }

    public KhachHangException(String message, Throwable cause) {
        super(message, cause);
    }

    public KhachHangException(Throwable cause) {
        super(cause);
    }

    public KhachHangException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static KhachHangException customerNotFound(String customerId) {
        return new KhachHangException("Customer not found with ID: " + customerId);
    }

    public static KhachHangException invalidCustomerData(String details) {
        return new KhachHangException("Invalid customer data: " + details);
    }

    public static KhachHangException duplicateCustomerEntry(String customerId) {
        return new KhachHangException("Duplicate customer entry with ID: " + customerId);
    }

    public void logException() {
        System.err.println("Exception occurred: " + this.getMessage());
        this.printStackTrace();
    }
}