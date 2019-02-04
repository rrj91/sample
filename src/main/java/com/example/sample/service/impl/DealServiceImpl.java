package com.example.sample.service.impl;

import com.example.sample.dto.DealDTO;
import com.example.sample.model.Company;
import com.example.sample.model.Deal;
import com.example.sample.repository.CompanyRepository;
import com.example.sample.repository.DealRepository;
import com.example.sample.service.DealService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DealRepository dealRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DealDTO saveDealOfCompany(DealDTO dealDTO,Long sourceCompanyId) {
        Deal deal = modelMapper.map(dealDTO,Deal.class);
        Long targetCompanyId = deal.getTargetCompany().getId();
        Company sourceCompany = companyRepository.findById(sourceCompanyId).get();
        Company targetCompany = companyRepository.findById(targetCompanyId).get();
        deal.setTargetCompany(targetCompany);
        deal.setParentCompany(sourceCompany);
        return modelMapper.map(dealRepository.save(deal),DealDTO.class);
    }

    @Override
    public List<DealDTO> getAll() {
        return modelMapper.map(dealRepository.findAll(),List.class);
    }

    @Override
    public DealDTO getDealByParentCompanyAndId(Long parentCompanyId,Long dealId) {
        Company parentCompany = companyRepository.findById(parentCompanyId).get();
        return modelMapper.map(dealRepository.findByParentCompanyAndId(parentCompany,dealId),DealDTO.class);
    }

    @Override
    public DealDTO getDealById(Long dealId) {
        return modelMapper.map(dealRepository.findById(dealId),DealDTO.class);
    }
}
