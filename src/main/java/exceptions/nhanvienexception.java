/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */

public class NhanVienException extends RuntimeException {
    private final int errorCode;

    public NhanVienException(String message) {
        super(message);
        this.errorCode = -1; 
    }

    public NhanVienException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = -1;
    }

    public NhanVienException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NhanVienException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public static NhanVienException notFound(String id) {
        return new NhanVienException("Nhân viên không tồn tại: " + id, 404);
    }

    public static NhanVienException duplicateEntry(String id) {
        return new NhanVienException("Nhân viên đã tồn tại: " + id, 409);
    }

    public static NhanVienException databaseError(String message, Throwable cause) {
        return new NhanVienException("Lỗi cơ sở dữ liệu: " + message, cause, 500);
    }

    public static NhanVienException validationError(String message) {
        return new NhanVienException("Lỗi xác thực: " + message, 400);
    }
}

