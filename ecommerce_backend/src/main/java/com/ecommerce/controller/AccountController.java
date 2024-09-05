package com.ecommerce.controller;

import com.ecommerce.DTO.AccountDTO;
import com.ecommerce.entity.Account;
import com.ecommerce.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountController {
//    @Autowired
//    private IAccountService accountService;
//
//    @Autowired
//    private ModelMapper modelMapper;
    private final IAccountService accountService;
    private final ModelMapper modelMapper;

    @GetMapping("/admin/users")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    @GetMapping("account/{id}")
    public AccountDTO getAccountById(@PathVariable("id") int id) {
        Account account =  accountService.getAccountById(id);
//        return account;
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        return accountDTO;
    }
}
