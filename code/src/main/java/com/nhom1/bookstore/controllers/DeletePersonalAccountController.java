package com.nhom1.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nhom1.bookstore.services.AccountService;

@Controller
public class DeletePersonalAccountController {
    private final AccountService accountService;

    public DeletePersonalAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/user/delete")
    public String login() {
        return "redirect:/trangchu";
    }
}
