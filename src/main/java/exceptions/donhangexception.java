/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */
public class donhangexception extends RuntimeException{
    public donhangexception(String message) {
        super(message);
    }

    public donhangexception(String message, Throwable cause) {
        super(message, cause);
    }
}
