package com.karolmalysa.insurancecenter.restcontrollers;


import com.karolmalysa.insurancecenter.model.components.ProductComponnent;
import com.karolmalysa.insurancecenter.model.dto.ProductDto;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {

    private  final ProductComponnent productComponnent;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        return productComponnent.saveProduct(productDto);

    }

    @GetMapping(produces = "application/json")
    public List<ProductDto> findAllProducts() {
        return  productComponnent.findAll();
    }

    @GetMapping(value = "/by-price/{minPrice}/{maxPrice}", produces = "application/json")
    public List<ProductDto> findProductsByPriceBetween(@PathVariable("minPrice") Long minPrice, @PathVariable ("maxPrice") Long maxPrice) {
        return  productComponnent.findByPriceBetween(minPrice, maxPrice );
    }

}
