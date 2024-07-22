/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */
public class sanphamexception extends RuntimeException {
    private final int errorCode;

    public sanphamexception(String message) {
        super(message);
        this.errorCode = -1; // default error code
    }

    public sanphamexception(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = -1; // default error code
    }

    public sanphamexception(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public sanphamexception(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public static sanphamexception notFound(String id) {
        return new sanphamexception("Sản phẩm không tồn tại: " + id, 404);
    }

    public static sanphamexception duplicateEntry(String id) {
        return new sanphamexception("Sản phẩm đã tồn tại: " + id, 409);
    }

    public static sanphamexception databaseError(String message, Throwable cause) {
        return new sanphamexception("Lỗi cơ sở dữ liệu: " + message, cause, 500);
    }

    public static sanphamexception validationError(String message) {
        return new sanphamexception("Lỗi xác thực: " + message, 400);
    }
}

