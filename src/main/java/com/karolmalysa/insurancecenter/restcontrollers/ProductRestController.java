package com.karolmalysa.insurancecenter.restcontrollers;


import com.karolmalysa.insurancecenter.model.components.ProductComponnent;
import com.karolmalysa.insurancecenter.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {

    private  final ProductComponnent productComponnent;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        return productComponnent.saveProduct(productDto);

    }


}
