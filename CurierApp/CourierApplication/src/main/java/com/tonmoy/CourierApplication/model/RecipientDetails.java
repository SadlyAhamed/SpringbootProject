package com.tonmoy.CourierApplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // create Table in DB
@Data // getter and Setter
@NoArgsConstructor // Default Constructor
@AllArgsConstructor // perameterised Constructor
@Table(name = "recipient_details")
public class RecipientDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int senderId;

    private String recipientName;

    private String recipientMobileNo;

    private String district;

    private String nearestArea;

    private String recipientAddress;

    private String instruction;

    private String sendPickNotifaction;
}
