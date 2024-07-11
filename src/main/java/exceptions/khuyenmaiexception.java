/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author maytinh
 */
public class KhuyenMaiException extends RuntimeException {
    private final String errorCode;

    public KhuyenMaiException(String message) {
        super(message);
        this.errorCode = null;
    }

    public KhuyenMaiException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
    }

    public KhuyenMaiException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public KhuyenMaiException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public static KhuyenMaiException notFound(String maKM) {
        return new KhuyenMaiException("Khuyến mãi với mã " + maKM + " không tìm thấy", "NOT_FOUND");
    }

    public static KhuyenMaiException duplicateEntry(String maKM) {
        return new KhuyenMaiException("Khuyến mãi với mã " + maKM + " đã tồn tại", "DUPLICATE_ENTRY");
    }

    public static KhuyenMaiException invalidData(String details) {
        return new KhuyenMaiException("Dữ liệu khuyến mãi không hợp lệ: " + details, "INVALID_DATA");
    }
}
