package com.karolmalysa.insurancecenter.model.dto;

import com.karolmalysa.insurancecenter.model.entities.CompanyClient;
import com.karolmalysa.insurancecenter.model.entities.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductDto {


    private Long id;

    private  String name;

    private Long amount = 1L;

    private  Float price; //BigDecimal?

    private Long idCompanyClient;


    public Product createEntity() {

        CompanyClient companyClient = new CompanyClient();
        companyClient.setId(this.idCompanyClient);
        Product product = new Product();

        product.setName(this.name);
        product.setAmount(this.amount);
        product.setPrice(this.price);
        product.setCompanyClient(companyClient); //podając samo id silnik doda relacje do tego klienta nawet jak się go nie pobierze z bazy danych. thanks K.W. ;)

        return product;
    }

    public  ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.amount = product.getAmount();
       this.price = product.getPrice();
       this.idCompanyClient = product.getCompanyClient().getId();
    }
}
