package com.nhom1.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nhom1.bookstore.services.AccountService;


@Controller
public class ManageAccountController {
    private final AccountService accountService;

    public ManageAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/quantri/taikhoan")
    public String getManageAccount(Model model) {
        // List<Account> accountList = accountService.getAccountList();
        // model.addAttribute("accountList", accountList);
        return "admin_account";
    }
}
