package com.nhom1.bookstore.entity;

import java.util.Date;

public class Order {
    private String maDonHang;
    private String idNguoiDat;
    private Date thoiGianDat;
    private String trangThai;
    private String thanhTien;
    private String idSachDau;
    private Book cuonSachDau;
    private int soSanPham;

    public Order() {}
    public Order(String MaDonHang, String nguoiDat, Date thoiGianDat, int trangThai, String thanhTien, String cuonSachDau, int soSanPham) {
        this.maDonHang = MaDonHang;
        this.idNguoiDat = nguoiDat;
        this.thoiGianDat = thoiGianDat;
        this.trangThai = convertTrangThai(trangThai);
        this.thanhTien = thanhTien;
        this.idSachDau = cuonSachDau;
        this.soSanPham = soSanPham;
    }
    public Order(String MaDonHang, String nguoiDat, int trangThai, String thanhTien) {
        this.maDonHang = MaDonHang;
        this.idNguoiDat = nguoiDat;
        this.trangThai = convertTrangThai(trangThai);
        this.thanhTien = thanhTien;
    }

    private String convertTrangThai(int trangThai) {
        switch (trangThai) {
            case 0:
                return "Chưa xác nhận";
            case 1:
                return "Đã xác nhận";
            case 2:
                return "Đang vận chuyển";
            case 3:
                return "Đã hoàn thành";
            default:
                return "Đã hủy";
        }
    }

    public String getMaDonHang() {
        return maDonHang;
    }
    public void setMaDonHang(String MaDonHang) {
        this.maDonHang = MaDonHang;
    }
    public String getIdNguoiDat() {
        return idNguoiDat;
    }
    public void setIdNguoiDat(String nguoiDat) {
        this.idNguoiDat = nguoiDat;
    }
    public Date getThoiGianDat() {
        return thoiGianDat;
    }
    public void setThoiGianDat(Date ThoiGianDat) {
        this.thoiGianDat = ThoiGianDat;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(int trangThai) {
        this.trangThai = convertTrangThai(trangThai);
    }
    public String getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }
    public String getFirstBook() {
        return idSachDau;
    }
    public void setFirstBook(Book cuonSachDau) {
        this.cuonSachDau = cuonSachDau;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public String getIdSachDau() {
        return idSachDau;
    }
    public void setIdSachDau(String idSachDau) {
        this.idSachDau = idSachDau;
    }
    public Book getCuonSachDau() {
        return cuonSachDau;
    }
    public void setCuonSachDau(Book cuonSachDau) {
        this.cuonSachDau = cuonSachDau;
    }
    public int getSoSanPham() {
        return soSanPham;
    }
    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }
}
