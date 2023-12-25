package com.nhom1.bookstore.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nhom1.bookstore.entity.Book;
import com.nhom1.bookstore.services.ConverterCurrency;

@Repository
public class BookDAOImpl implements BookDAO{
    private Connection conn;

    public BookDAOImpl() {
        this.conn = JDBC.getConnection();
        if(conn != null) {System.out.println("Book connect success");}
    }

    @Override
    public void addBook(Book newBook) {
        
    }

    @Override
    public void deleteBook(String id) {
       
    }

    @Override
    public void editBook(String currentID, Book newBook) {
        String sql = "UPDATE Sach SET MatKhau=?, HoTen=?, SoDienThoai=?, Email=?, DiaChi=? WHERE ID = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(2, "ho_ten_moi");
            statement.setString(3, "so_dien_thoai_moi");
            statement.setString(4, "email_moi");
            statement.setString(5, "dia_chi_moi");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getBook(String id) {
        String sql = "SELECT * FROM Sach where id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String ten = resultSet.getString("Ten");
                    String hinhAnh = resultSet.getString("HinhAnh");
                    String tacGia = resultSet.getString("TacGia");
                    String nhaCungCap = resultSet.getString("NhaCungCap");
                    int tonKho = resultSet.getInt("TonKho");
                    
                    int giaRaw = resultSet.getInt("Gia");
                    String gia = ConverterCurrency.numberToCurrency(giaRaw);
                    
                    int daBan = resultSet.getInt("DaBan");
                    double trongLuong = resultSet.getDouble("TrongLuong");
                    String kichThuoc = resultSet.getString("KichThuoc");
                    String gioiThieu = resultSet.getString("GioiThieu");

                     return new Book(id, ten, hinhAnh, tacGia, nhaCungCap, tonKho, gia, daBan, trongLuong, kichThuoc, gioiThieu);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("ID");
                    String ten = resultSet.getString("Ten");
                    String hinhAnh = resultSet.getString("HinhAnh");
                    String tacGia = resultSet.getString("TacGia");
                    String nhaCungCap = resultSet.getString("NhaCungCap");
                    int tonKho = resultSet.getInt("TonKho");

                    int giaRaw = resultSet.getInt("Gia");
                    String gia = ConverterCurrency.numberToCurrency(giaRaw);
                    
                    int daBan = resultSet.getInt("DaBan");
                    double trongLuong = resultSet.getDouble("TrongLuong");
                    String kichThuoc = resultSet.getString("KichThuoc");
                    String gioiThieu = resultSet.getString("GioiThieu");

                    bookList.add(new Book(id, ten, hinhAnh, tacGia, nhaCungCap, tonKho, gia, daBan, trongLuong, kichThuoc, gioiThieu));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> search(String tuKhoa) {
        List<Book> result = new ArrayList<>();
        String sql = "SELECT * FROM TaiKhoan WHERE LOWER(ID) LIKE LOWER(?) OR LOWER(Ten) LIKE LOWER(?) OR LOWER(TacGia) LIKE LOWER(?) OR LOWER(NhaCungCap) LIKE LOWER(?) OR LOWER(Gia) LIKE LOWER(?) OR LOWER(GioiThieu) LIKE LOWER(?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + tuKhoa + "%");
            preparedStatement.setString(2, "%" + tuKhoa + "%");
            preparedStatement.setString(3, "%" + tuKhoa + "%");
            preparedStatement.setString(4, "%" + tuKhoa + "%");
            preparedStatement.setString(5, "%" + tuKhoa + "%");
            preparedStatement.setString(6, "%" + tuKhoa + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String ten = resultSet.getString("Ten");
                    String hinhAnh = resultSet.getString("HinhAnh");
                    String tacGia = resultSet.getString("TacGia");
                    String nhaCungCap = resultSet.getString("NhaCungCap");
                    int tonKho = resultSet.getInt("TonKho");
                    
                    int giaRaw = resultSet.getInt("Gia");
                    String gia = ConverterCurrency.numberToCurrency(giaRaw);
                    
                    int daBan = resultSet.getInt("DaBan");
                    double trongLuong = resultSet.getDouble("TrongLuong");
                    String kichThuoc = resultSet.getString("KichThuoc");
                    String gioiThieu = resultSet.getString("GioiThieu");
                    result.add(new Book(sql, ten, hinhAnh, tacGia, nhaCungCap, tonKho, gia, daBan, trongLuong, kichThuoc, gioiThieu));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
