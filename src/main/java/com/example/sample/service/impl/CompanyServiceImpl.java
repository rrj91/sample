package com.example.sample.service.impl;

import com.example.sample.dto.CompanyDTO;
import com.example.sample.model.Company;
import com.example.sample.repository.CompanyRepository;
import com.example.sample.service.CompanyService;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CompanyDTO saveCompany(CompanyDTO companyDTO) {
        Company company = modelMapper.map(companyDTO,Company.class);
        return modelMapper.map(companyRepository.save(company),CompanyDTO.class);
    }

    @Override
    public List<CompanyDTO> getAll() {
        return modelMapper.map(companyRepository.findAll(),List.class);
    }

    @Override
    public CompanyDTO getCompanyById(Long companyId) {
        return modelMapper.map(companyRepository.findById(companyId),CompanyDTO.class);
    }
}
