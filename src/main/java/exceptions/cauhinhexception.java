/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */
public class CauHinhException extends RuntimeException {
    public CauHinhException(String message) {
        super(message);
    }

    public CauHinhException(String message, Throwable cause) {
        super(message, cause);
    }

    public CauHinhException(Throwable cause) {
        super(cause);
    }

    public static CauHinhException configurationNotFound(String configName) {
        return new CauHinhException("Configuration not found: " + configName);
    }
}

