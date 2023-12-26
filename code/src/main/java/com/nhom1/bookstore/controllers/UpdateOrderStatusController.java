package com.nhom1.bookstore.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom1.bookstore.entity.Account;

public class UpdateOrderStatusController {

    // @PostMapping("/quantri")
    // public String register(Model model, CheckEmail checkEmail,
    // @RequestParam("register-email") String email, 
    // @RequestParam("register-username") String username, 
    // @RequestParam("register-password") String password1, 
    // @RequestParam("confirm-password") String password2) {
    //     if(checkEmail.checkEmail(accountService,email)) {
    //         if(accountService.checkUsername(username)){
    //             if(password1.equals(password2)) {
    //                 accountService.registerAccount(new Account(username, email, password1));
    //                 thongbao = "";
    //                 return "redirect:/dangnhap";
    //             } else{
    //                 thongbao = "Mật khẩu nhập lại không chính xác";
    //                 return "redirect:/dangky";
    //             }
    //         } else{
    //             thongbao =  "Tên đăng nhập này đã được sử dụng";
    //             return "redirect:/dangky";
    //         }
    //     } else{
    //         thongbao =  "Email này đã được sử dụng";
    //         return "redirect:/dangky";
    //     }
    // }
}
