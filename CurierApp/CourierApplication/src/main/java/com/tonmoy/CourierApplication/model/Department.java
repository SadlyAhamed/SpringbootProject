package com.tonmoy.CourierApplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="department")



public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int depid;

    @Column(length = 30, nullable = false)
    private  String depName;

    @Column(length = 30, nullable = false)
    private  String depCode;
}
