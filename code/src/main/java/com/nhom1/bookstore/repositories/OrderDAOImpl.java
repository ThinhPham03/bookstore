package com.nhom1.bookstore.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nhom1.bookstore.entity.Order;
import com.nhom1.bookstore.entity.OrderDetail;
import com.nhom1.bookstore.services.ConverterCurrency;

@Repository
public class OrderDAOImpl implements OrderDAO{
    private Connection conn;

    public OrderDAOImpl() {
        this.conn = JDBC.getConnection();
        if(conn != null) {System.out.println("Order connect success");}
    }

    @Override
    public void deleteOrder(String id) {
       
    }

    @Override
    public void editOrder(String currentID, Order newOrder) {
    
    }

    @Override
    public Order getOrder(String id) {
       String sql = "SELECT * FROM DonHang where MaDonHang = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String maDonHang = resultSet.getString("MaDonHang");
                    String idNguoiDat = resultSet.getString("IDNguoiDat");
                    int trangThai = resultSet.getInt("TrangThai");
                    int thanhTienRaw = resultSet.getInt("ThanhTien");
                    String thanhTien = ConverterCurrency.numberToCurrency(thanhTienRaw);

                    return new Order(maDonHang, idNguoiDat, trangThai, thanhTien);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderDetail getOrderDetail(String id) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setMaDonHang(id);
        orderDetail.setBookList(new ArrayList<>());
        String sql = "SELECT * FROM ChiTietDonHang where MaDonHang = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String idSach = resultSet.getString("IDSach");
                    int soLuong = resultSet.getInt("SoLuong");
                    OrderDetail.BookInOrder bookInOrder = orderDetail.new BookInOrder(idSach, soLuong);
                    orderDetail.getBookList().add(bookInOrder);
                }
                return orderDetail;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM DonHang";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String maDonHang = resultSet.getString("MaDonHang");
                    String idNguoiDat = resultSet.getString("IDNguoiDat");
                    Date thoiGianDat = resultSet.getTimestamp("ThoiGianDat");
                    int trangThai = resultSet.getInt("TrangThai");
                    int thanhTienRaw = resultSet.getInt("ThanhTien");
                    String thanhTien = ConverterCurrency.numberToCurrency(thanhTienRaw);
                    String idSachDau = resultSet.getString("CuonSachDau");
                    int soSanPham = resultSet.getInt("SoSanPham");
                    orderList.add(new Order(maDonHang, idNguoiDat, thoiGianDat, trangThai, thanhTien, idSachDau, soSanPham));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> search(String tuKhoa) {
        List<Order> result = new ArrayList<>();
        String sql = "SELECT * FROM DonHang WHERE LOWER(MaDonHang) LIKE LOWER(?) OR LOWER(IDNguoiDat) LIKE LOWER(?) OR LOWER(ThoiGianDat) LIKE LOWER(?) OR LOWER(CuonSachDau) LIKE LOWER(?) OR LOWER(SoSanPham) LIKE LOWER(?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + tuKhoa + "%");
            preparedStatement.setString(2, "%" + tuKhoa + "%");
            preparedStatement.setString(3, "%" + tuKhoa + "%");
            preparedStatement.setString(4, "%" + tuKhoa + "%");
            preparedStatement.setString(5, "%" + tuKhoa + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String maDonHang = resultSet.getString("MaDonHang");
                    String idNguoiDat = resultSet.getString("IDNguoiDat");
                    Date thoiGianDat = resultSet.getTimestamp("ThoiGianDat");
                    int trangThai = resultSet.getInt("TrangThai");

                    int thanhTienRaw = resultSet.getInt("ThanhTien");
                    String thanhTien = ConverterCurrency.numberToCurrency(thanhTienRaw);

                    String idSachDau = resultSet.getString("CuonSachDau");
                    int soSanPham = resultSet.getInt("SoSanPham");
                    result.add(new Order(maDonHang, idNguoiDat, thoiGianDat, trangThai, thanhTien, idSachDau, soSanPham));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}