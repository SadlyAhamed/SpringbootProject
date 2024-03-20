package com.tonmoy.CourierApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity // create Table in DB
@Data // getter and Setter
@AllArgsConstructor // perameterised Constructor
@Table(name = "parcel_details")
public class ParcelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int senderId;

    private int recipientId;

    private String selectProductType;

    private String packageWeight;

    private String whatDoesThisParcelContain;

    private String numberOfItem;

    private String payment;


    @Column(name = "pp_Traking_no", unique = true, updatable = false)
    private String parcelTrakingNumber;


    public ParcelDetails() {
        this.parcelTrakingNumber = UUID.randomUUID().toString();

    }
}
