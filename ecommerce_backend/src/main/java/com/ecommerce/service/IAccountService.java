package com.ecommerce.service;

import com.ecommerce.entity.Account;
import com.ecommerce.form.ChangePasswordForm;
import com.ecommerce.form.CreateAccountForm;
import com.ecommerce.form.ForgetPasswordForm;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public interface IAccountService extends UserDetailsService {
    public Account getAccountById(int id);

    public Account getAccountByUsername(String username);

    public List<Account> getAllAccount();

    public boolean createAccount(CreateAccountForm form);

    public String forgetPassword(ForgetPasswordForm form) throws MessagingException;

    public boolean changePassword(int id, ChangePasswordForm form);
}
