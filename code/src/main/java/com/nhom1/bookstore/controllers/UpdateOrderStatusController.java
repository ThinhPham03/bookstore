package com.nhom1.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom1.bookstore.services.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UpdateOrderStatusController {
    private final OrderService orderService;

    public UpdateOrderStatusController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/quantri/donhang/capnhantrangthai")
    public String register(HttpSession session,
    @RequestParam("ID") String maDonHang,
    @RequestParam("orderStatus") String orderStatusRaw) {
        int orderStatus = Integer.parseInt(orderStatusRaw);
        orderService.editStatusOrder(maDonHang, orderStatus);
        return "redirect:/quantri/donhang";
    }
}
