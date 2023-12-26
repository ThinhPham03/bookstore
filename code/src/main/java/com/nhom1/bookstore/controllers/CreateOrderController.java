package com.nhom1.bookstore.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nhom1.bookstore.entity.Book;

@Controller
public class CreateOrderController {

    @PostMapping("/giohang/thanhtoan")
    public void receiveCartData(@RequestBody List<Book> cart) {
        // Xử lý dữ liệu giỏ hàng tại phía máy chủ
        for (Book book : cart) {
            // Đối với mỗi sách trong giỏ hàng, bạn có thể thực hiện các thao tác xử lý dữ liệu
            System.out.println(book);
        }

        // Trả về một phản hồi nếu cần
    }
}
