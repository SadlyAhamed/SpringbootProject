package com.tonmoy.CourierApplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sender_details")

public class SenderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String senderName;

    private String senderMobileNo;

    private String email;

    private String PickAddressType;

    private String district;

    private String nearestArea;

    private String senderAddress;

    private String password;

    private String role;

    private boolean isEnabled;

}
