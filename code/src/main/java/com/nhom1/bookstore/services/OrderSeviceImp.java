package com.nhom1.bookstore.services;

import java.util.List;
import org.springframework.stereotype.Service;

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
    public void editOrder(String currentID, Order newOrder) {
        orderDAOController.editOrder(currentID, newOrder);
    }

    @Override
    public List<Order> search(String tuKhoa) {
        return orderDAOController.search(tuKhoa);
    }

    @Override
    public void deleteOrder(String id) {
        orderDAOController.deleteOrder(id);;
    }

    @Override
    public OrderDetail getOrderDetail(String id) {
        return orderDAOController.getOrderDetail(id);
    }

    
}
