package com.nhom1.bookstore.repositories;

import java.util.List;
import org.springframework.stereotype.Controller;

import com.nhom1.bookstore.entity.Order;
import com.nhom1.bookstore.entity.OrderDetail;

@Controller
public class OrderDAOControllerImpl implements OrderDAOController{
    public final OrderDAO orderDAO;

    public OrderDAOControllerImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void deleteOrder(String id) {
        orderDAO.deleteOrder(id);
    }

    @Override
    public void editOrder(String currentID, Order newOrder) {
        orderDAO.editOrder(currentID, newOrder);
    }

    @Override
    public Order getOrder(String id) {
        return orderDAO.getOrder(id);
    }

    @Override
    public List<Order> getOrderList() {
        return orderDAO.getOrderList();
    }

    @Override
    public List<Order> search(String tuKhoa) {
        return orderDAO.search(tuKhoa);
    }

    @Override
    public OrderDetail getOrderDetail(String id) {
        return orderDAO.getOrderDetail(id);
    }
}
