package com.ecommerce.auditing;

import com.ecommerce.entity.Account;
import com.ecommerce.entity.CustomUserDetail;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if (authentication == null ||
               !authentication.isAuthenticated() ||
               (authentication instanceof AnonymousAuthenticationToken)
       ) {
           return Optional.empty();
       }

        CustomUserDetail userPrincipal = (CustomUserDetail) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getAccount());
    }
}
