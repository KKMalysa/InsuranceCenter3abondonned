package com.karolmalysa.insurancecenter.model.dao;

import com.karolmalysa.insurancecenter.model.entities.CompanyClient;
import com.karolmalysa.insurancecenter.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyClientRepository extends JpaRepository<CompanyClient, Long> {


}
