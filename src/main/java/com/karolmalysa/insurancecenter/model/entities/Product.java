package com.karolmalysa.insurancecenter.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "insurances")
@NamedQueries(value = {
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findByPriceBetween", query = "SELECT p FROM Product p where p.price >= :minPrice and p.price <= :maxPrice"),
})
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

}
