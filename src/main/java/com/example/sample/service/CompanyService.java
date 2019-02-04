package com.example.sample.service;

import com.example.sample.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO saveCompany(CompanyDTO companyDTO);
    List<CompanyDTO> getAll();
    CompanyDTO getCompanyById(Long companyId);
}
