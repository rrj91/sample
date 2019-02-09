package com.example.sample.service.impl;

import com.example.sample.dto.DealDTO;
import com.example.sample.model.Company;
import com.example.sample.model.Deal;
import com.example.sample.model.Role;
import com.example.sample.model.User;
import com.example.sample.repository.CompanyRepository;
import com.example.sample.repository.DealRepository;
import com.example.sample.repository.RoleRepository;
import com.example.sample.repository.UserRepository;
import com.example.sample.service.DealService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DealRepository dealRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DealDTO saveDealOfCompany(DealDTO dealDTO,Long sourceCompanyId) {
        Deal deal = null;
        Role role = roleRepository.findById(dealDTO.getRole().getId()).get();
        User user = userRepository.findById(dealDTO.getUser().getId()).get();
        Map map = new HashMap<Role, User>();
        map.put(role, user);
        if (dealDTO.getId() != null) {
            deal = dealRepository.findById(dealDTO.getId()).get();
            Map roleuser = deal.getUserRolesMap();
            roleuser.putAll(map);
        } else {
            deal = modelMapper.map(dealDTO, Deal.class);
            deal.setUserRolesMap(map);
            Long targetCompanyId = deal.getTargetCompany().getId();
            Company sourceCompany = companyRepository.findById(sourceCompanyId).get();
            Company targetCompany = companyRepository.findById(targetCompanyId).get();
            deal.setTargetCompany(targetCompany);
            deal.setParentCompany(sourceCompany);
        }
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
