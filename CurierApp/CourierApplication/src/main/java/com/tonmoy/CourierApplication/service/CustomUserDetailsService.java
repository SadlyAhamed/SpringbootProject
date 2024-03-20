package com.tonmoy.CourierApplication.service;

import com.tonmoy.CourierApplication.model.CustomUserDetails;
import com.tonmoy.CourierApplication.model.SenderDetails;
import com.tonmoy.CourierApplication.repository.SenderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    SenderDetailsRepository senderDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SenderDetails u= senderDetailsRepository.findByEmail(email);
        if(u==null){
            throw new UsernameNotFoundException("This email id not found");
        }

        return (UserDetails) new CustomUserDetails(u);
    }

}
