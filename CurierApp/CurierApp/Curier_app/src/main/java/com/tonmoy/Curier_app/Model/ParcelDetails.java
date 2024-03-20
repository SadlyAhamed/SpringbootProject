package com.tonmoy.Curier_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Entity // create Table in DB
@Data // getter and Setter
// Default Constructor
@AllArgsConstructor // perameterised Constructor
@Table(name = "parcel_details")

public class ParcelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int senderId;
    private int recipientId;
    private String selectProductType;
    private String packageWeight ;
    private String whatDoesThisParcelContain;
    private String  numberOfItem;
    private String payment;

    @Column(name = "pp_Traking_no", unique = true, updatable = false)
    private String parcelTrakingNumber;

    public ParcelDetails(){
        this.parcelTrakingNumber= UUID.randomUUID().toString();

    }
}
