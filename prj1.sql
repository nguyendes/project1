-- Table: LoaiSP
CREATE TABLE LoaiSP (
    MaLoaiSP NVARCHAR(10) PRIMARY KEY,
    TenLoai NVARCHAR(50) NOT NULL
);

-- Table: NhaCungCap
CREATE TABLE NhaCungCap (
    MaNhaCC NVARCHAR(10) PRIMARY KEY,
    TenNhaCC NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50),
    SDT NVARCHAR(12)
);

-- Table: ChatLieuSP
CREATE TABLE ChatLieuSP (
    MaChatLieu NVARCHAR(10) PRIMARY KEY,
    ChatLieu NVARCHAR(50) NOT NULL
);

-- Table: KhachHang
CREATE TABLE KhachHang (
    MaKH NVARCHAR(10) PRIMARY KEY,
    Ho NVARCHAR(50),
    Ten NVARCHAR(50) NOT NULL,
    SDTChinh NVARCHAR(12) UNIQUE NOT NULL,
    EmailChinh NVARCHAR(50) UNIQUE NOT NULL
);

-- Table: NhanVien
CREATE TABLE NhanVien (
    MaNV NVARCHAR(10) PRIMARY KEY,
    Ho NVARCHAR(50),
    Ten NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50) UNIQUE NOT NULL,
    SDT NVARCHAR(12) UNIQUE NOT NULL,
    ChucVu NVARCHAR(50) NOT NULL
);

-- Table: DonHang
CREATE TABLE DonHang (
    MaDH NVARCHAR(10) PRIMARY KEY,
    NgayMua DATE NOT NULL,
    TrangThai NVARCHAR(50),
    MaKH NVARCHAR(10),
    MaNV NVARCHAR(10),
    TongTien DECIMAL(10,2) NOT NULL,
    PhuongThucTT NVARCHAR(50),
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH) ON DELETE CASCADE,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE CASCADE
);

-- Table: SanPham
CREATE TABLE SanPham (
    MaSP NVARCHAR(10) PRIMARY KEY,
    Ten NVARCHAR(50) NOT NULL,
    GiaHienTai DECIMAL(10,2) NOT NULL,
    SoLuongTon INT NOT NULL,
    MaLoaiSP NVARCHAR(10),
    MaNhaCC NVARCHAR(10),
    MauSac NVARCHAR(50),
    MaChatLieu NVARCHAR(10),
    Size NVARCHAR(10),
    FOREIGN KEY (MaLoaiSP) REFERENCES LoaiSP(MaLoaiSP) ON DELETE CASCADE,
    FOREIGN KEY (MaNhaCC) REFERENCES NhaCungCap(MaNhaCC) ON DELETE CASCADE,
    FOREIGN KEY (MaChatLieu) REFERENCES ChatLieuSP(MaChatLieu) ON DELETE CASCADE
);

-- Table: KhuyenMai
CREATE TABLE KhuyenMai (
    MaKM NVARCHAR(10) PRIMARY KEY,
    TenKM NVARCHAR(50) NOT NULL,
    KieuKM NVARCHAR(50),
    NgayBatDau DATE NOT NULL,
    NgayKetThuc DATE NOT NULL
);

-- Table: CTKMVC (ChiTietKMVC)
CREATE TABLE CTKMVC (
    MaSP NVARCHAR(10),
    MaKM NVARCHAR(10),
    TienGiam DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (MaSP, MaKM),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP) ON DELETE CASCADE,
    FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKM) ON DELETE CASCADE
);

-- Table: CTKMP (ChiTietKMP)
CREATE TABLE CTKMP (
    MaSP NVARCHAR(10),
    MaKM NVARCHAR(10),
    TienGiam DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (MaSP, MaKM),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP) ON DELETE CASCADE,
    FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKM) ON DELETE CASCADE
);

-- Table: CTDonHang
CREATE TABLE CTDonHang (
    MaDH NVARCHAR(10),
    MaSP NVARCHAR(10),
    MaKM NVARCHAR(10),
    GiaBan DECIMAL(10,2) NOT NULL,
    SoLuong INT NOT NULL,
    PRIMARY KEY (MaDH, MaSP),
    FOREIGN KEY (MaDH) REFERENCES DonHang(MaDH) ON DELETE CASCADE,
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP) ON DELETE CASCADE,
    FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKM) ON DELETE CASCADE
);

-- Table: Log
CREATE TABLE Log (
    LogID INT PRIMARY KEY IDENTITY(1,1),
    HanhDong NVARCHAR(255) NOT NULL,
    MaNV NVARCHAR(10),
    Ngay DATE NOT NULL,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE CASCADE
);

-- Insert sample data into NhanVien
INSERT INTO NhanVien (MaNV, Ho, Ten, ChucVu, Email, SDT)
VALUES (N'001', N'Nguyễn', N'Văn A', N'Nhân Viên', N'nguyenvana@gmail.com', N'0123456789');


--Trigger LoaiSP
CREATE TRIGGER trgAfterInsertLoaiSP
ON LoaiSP
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới loại sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateLoaiSP
ON LoaiSP
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật loại sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteLoaiSP
ON LoaiSP
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa loại sản phẩm', NULL, GETDATE());
END;


--Trigger NhaCungCap
CREATE TRIGGER trgAfterInsertNhaCungCap
ON NhaCungCap
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới nhà cung cấp', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateNhaCungCap
ON NhaCungCap
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật nhà cung cấp', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteNhaCungCap
ON NhaCungCap
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa nhà cung cấp', NULL, GETDATE());
END;


--Trigger ChatLieuSP
CREATE TRIGGER trgAfterInsertChatLieuSP
ON ChatLieuSP
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới chất liệu sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateChatLieuSP
ON ChatLieuSP
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật chất liệu sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteChatLieuSP
ON ChatLieuSP
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa chất liệu sản phẩm', NULL, GETDATE());
END;


--Trigger KhachHang
CREATE TRIGGER trgAfterInsertKhachHang
ON KhachHang
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới khách hàng', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateKhachHang
ON KhachHang
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật khách hàng', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteKhachHang
ON KhachHang
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa khách hàng', NULL, GETDATE());
END;


--Trigger NhanVien
CREATE TRIGGER trgAfterInsertNhanVien
ON NhanVien
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    SELECT 'Thêm mới nhân viên', MaNV, GETDATE()
    FROM INSERTED;
END;

CREATE TRIGGER trgAfterUpdateNhanVien
ON NhanVien
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    SELECT 'Cập nhật nhân viên', MaNV, GETDATE()
    FROM INSERTED;
END;

CREATE TRIGGER trgAfterDeleteNhanVien
ON NhanVien
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    SELECT 'Xóa nhân viên', MaNV, GETDATE()
    FROM DELETED;
END;


--Trigger DonHang
CREATE TRIGGER trgAfterInsertDonHang
ON DonHang
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    SELECT 'Thêm mới đơn hàng', MaNV, GETDATE()
    FROM INSERTED;
END;

CREATE TRIGGER trgAfterUpdateDonHang
ON DonHang
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    SELECT 'Cập nhật đơn hàng', MaNV, GETDATE()
    FROM INSERTED;
END;

CREATE TRIGGER trgAfterDeleteDonHang
ON DonHang
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    SELECT 'Xóa đơn hàng', MaNV, GETDATE()
    FROM DELETED;
END;


--Trigger SanPham
CREATE TRIGGER trgAfterInsertSanPham
ON SanPham
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateSanPham
ON SanPham
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteSanPham
ON SanPham
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa sản phẩm', NULL, GETDATE());
END;


--Trigger KhuyenMai
CREATE TRIGGER trgAfterInsertKhuyenMai
ON KhuyenMai
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới khuyến mãi', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateKhuyenMai
ON KhuyenMai
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật khuyến mãi', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteKhuyenMai
ON KhuyenMai
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa khuyến mãi', NULL, GETDATE());
END;


--Trigger CTKMVC (ChiTietKMVC)
CREATE TRIGGER trgAfterInsertCTKMVC
ON CTKMVC
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới chi tiết khuyến mãi voucher', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateCTKMVC
ON CTKMVC
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật chi tiết khuyến mãi voucher', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteCTKMVC
ON CTKMVC
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa chi tiết khuyến mãi voucher', NULL, GETDATE());
END;


--Trigger CTKMP (ChiTietKMP)
CREATE TRIGGER trgAfterInsertCTKMP
ON CTKMP
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới chi tiết khuyến mãi sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateCTKMP
ON CTKMP
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật chi tiết khuyến mãi sản phẩm', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteCTKMP
ON CTKMP
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa chi tiết khuyến mãi sản phẩm', NULL, GETDATE());
END;


--Trigger CTDonHang
CREATE TRIGGER trgAfterInsertCTDonHang
ON CTDonHang
AFTER INSERT
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Thêm mới chi tiết đơn hàng', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterUpdateCTDonHang
ON CTDonHang
AFTER UPDATE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Cập nhật chi tiết đơn hàng', NULL, GETDATE());
END;

CREATE TRIGGER trgAfterDeleteCTDonHang
ON CTDonHang
AFTER DELETE
AS
BEGIN
    INSERT INTO Log (HanhDong, MaNV, Ngay)
    VALUES ('Xóa chi tiết đơn hàng', NULL, GETDATE());
END;
