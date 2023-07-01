package com.karolmalysa.insurancecenter.model.components;

import com.karolmalysa.insurancecenter.model.dao.CompanyClientRepository;
import com.karolmalysa.insurancecenter.model.dao.ProductRepository;
import com.karolmalysa.insurancecenter.model.dto.CompanyClientDto;
import com.karolmalysa.insurancecenter.model.dto.ProductDto;
import com.karolmalysa.insurancecenter.model.entities.CompanyClient;
import com.karolmalysa.insurancecenter.model.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyClientComponnent {

    private final CompanyClientRepository companyClientRepository;


    public CompanyClientDto saveCompanyClient (CompanyClientDto companyClientDto) {
        CompanyClient companyClient = companyClientRepository.save(companyClientDto.createEntity());

        return new CompanyClientDto(companyClient);
    }


    public List<CompanyClientDto> findAll () {
        return companyClientRepository.findAll().stream()
                .map(CompanyClientDto::new)                                                                             //thanks KW
                .collect(Collectors.toList());

    }

    /** pagination */
    public List<CompanyClientDto> findAll (Integer pageNumber, Integer pageSize) {
        return companyClientRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream()
                .map(CompanyClientDto::new)
                .collect(Collectors.toList());

    }


}
