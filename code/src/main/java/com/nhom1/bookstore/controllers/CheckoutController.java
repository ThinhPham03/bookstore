package com.nhom1.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nhom1.bookstore.entity.Account;
import com.nhom1.bookstore.services.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CheckoutController {
    private final AccountService accountService;
    
    public CheckoutController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/giohang/thanhtoan")
    public String getCheckOut(HttpSession session, Model model) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if(loggedInUser != null) {
            Account account = accountService.getAccountNonPassword(loggedInUser.toString());
            model.addAttribute("account", account);
            if(account.getDiaChi().isEmpty()) {
                model.addAttribute("noAddress", false);
            }else{
                model.addAttribute("noAddress", true);
            }
            return "thanhtoan";
        }
        return "redirect:/dangnhap";
    }
}
