package com.nhom1.bookstore.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom1.bookstore.DTO.OrderDTO;
import com.nhom1.bookstore.DTO.OrderDTO.BookDTO;
import com.nhom1.bookstore.entity.Order;
import com.nhom1.bookstore.entity.OrderDetail;
import com.nhom1.bookstore.repositories.OrderDAOController;

@Service
public class OrderSeviceImp implements OrderService {
    private final OrderDAOController orderDAOController;

    public OrderSeviceImp(OrderDAOController orderDAOController) {
        this.orderDAOController = orderDAOController;
    }

    @Override
    public List<Order> getOrderList() {
        return orderDAOController.getOrderList();
    }



    @Override
    public Order getOrder(String id) {
        return orderDAOController.getOrder(id);
    }

    @Override
    public void editStatusOrder(String currentID, int newStatus) {
        orderDAOController.editStatusOrder(currentID, newStatus);
    }

    @Override
    public List<Order> search(String tuKhoa) {
        return orderDAOController.search(tuKhoa);
    }

    @Override
    public OrderDetail getOrderDetail(String id) {
        return orderDAOController.getOrderDetail(id);
    }

    @Override
    public void createOrder(String idNguoiDat, OrderDTO newOrder) {
        String maDonHang = IDGenerator.IDOrder();
        Order order = new Order();
        order.setMaDonHang(maDonHang);
        order.setIdNguoiDat(idNguoiDat);
        order.setThoiGianDat(new Date());
        int trangThai = 0;
        if(newOrder.getPaymentMethod() == "momo") {
            trangThai = 1;
        }
        order.setTrangThai(trangThai);
        order.setThanhTien(newOrder.getPrice());
        order.setIdSachDau(newOrder.getBookList().get(0).getID());
        order.setSoSanPham(newOrder.getBookList().size());
        orderDAOController.createOrder(order);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setMaDonHang(maDonHang);
        orderDetail.setSoDienThoai(newOrder.getPhone());
        orderDetail.setDiaChi(newOrder.getAddress());

        orderDetail.setBookList(new ArrayList<>());
        
        List<OrderDTO.BookDTO> bookList =  newOrder.getBookList();
        for (BookDTO bookDTO : bookList) {
            String idSach = bookDTO.getID();
            int soLuong = bookDTO.getSoLuong();

            OrderDetail.BookInOrder bookInOrder = orderDetail.new BookInOrder(idSach, soLuong);
            orderDetail.getBookList().add(bookInOrder);
        }
        orderDAOController.createOrderDetail(orderDetail);
    }
}
