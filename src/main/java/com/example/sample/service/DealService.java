package com.example.sample.service;

import com.example.sample.dto.DealDTO;

import java.util.List;

public interface DealService {

    DealDTO saveDealOfCompany(DealDTO dealDTO,Long sourceCompanyId);
    List<DealDTO> getAll();
    DealDTO getDealByParentCompanyAndId(Long parentCompanyId,Long dealId);
    DealDTO getDealById(Long dealId);
}
