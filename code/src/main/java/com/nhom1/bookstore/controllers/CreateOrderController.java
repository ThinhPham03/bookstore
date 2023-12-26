package com.nhom1.bookstore.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CreateOrderController {

    @PostMapping("/giohang/thanhtoan")
    public ResponseEntity<String> processFormData(@RequestBody Map<String, String> requestData) {
        String tableId = requestData.get("tableId");
        String soluong = requestData.get("soluong");

        // Xử lý dữ liệu ở đây
        System.out.println("Table ID: " + tableId);
        System.out.println("Soluong: " + soluong);

        // Trả về kết quả (có thể là mã HTTP 200 OK)
        return ResponseEntity.ok("Data received successfully");
    }
}
