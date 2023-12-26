package com.nhom1.bookstore.services;

import java.util.List;

import com.nhom1.bookstore.entity.Order;
import com.nhom1.bookstore.entity.OrderDetail;

public interface OrderService {
    List<Order> getOrderList();
    Order getOrder(String id);
    OrderDetail getOrderDetail(String id);
    void editOrder(String currentID, Order newOrder);
    void deleteOrder(String id);
    List<Order> search(String tuKhoa);
}
