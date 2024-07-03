/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */

public class nhanvienexception extends RuntimeException {
    public nhanvienexception(String message) {
        super(message);
    }

    public nhanvienexception(String message, Throwable cause) {
        super(message, cause);
    }
}

