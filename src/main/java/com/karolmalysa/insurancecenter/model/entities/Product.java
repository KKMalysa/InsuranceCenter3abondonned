package com.karolmalysa.insurancecenter.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "insurances")
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementation of id
    private Long id;

    @Column(name = "name", length = 80, unique = true, nullable = false)
    private  String name;

    @Column(name = "amount", nullable = false)
    private Long amount = 1L;
    @Column(name = "price", nullable = false)
    private  Float price; //BigDecimal?

    @ManyToOne
    @JoinColumn(name = "idCompanyClient", nullable = false)
    private CompanyClient companyClient;

}
