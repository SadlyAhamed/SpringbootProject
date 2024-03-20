package com.tonmoy.CourierApplication.model;

import com.tonmoy.CourierApplication.repository.SenderDetailsRepository;
import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails {

    private SenderDetails u;


    public CustomUserDetails(SenderDetails u) {
        this.u = u;
    }

    private SenderDetailsRepository repo;

    public CustomUserDetails() {
        super();
    }
}
