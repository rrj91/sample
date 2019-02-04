package com.example.sample.controller;

import com.example.sample.dto.CompanyDTO;
import com.example.sample.dto.DealDTO;
import com.example.sample.model.Company;
import com.example.sample.model.Deal;
import com.example.sample.service.CompanyService;
import com.example.sample.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/companies")
public class CompanyController {
    @Autowired
    private DealService dealService;

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAll(){
        List<CompanyDTO> companyDTOS = companyService.getAll();
        if(companyDTOS != null && companyDTOS.size() > 0)
            return new ResponseEntity<>(companyDTOS, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/{companyId}")
    public ResponseEntity<CompanyDTO> findById(Long companyId){
        CompanyDTO companyDTO = companyService.getCompanyById(companyId);
        if(companyDTO != null)
            return new ResponseEntity<>(companyDTO,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO){
        CompanyDTO createdCompany = companyService.saveCompany(companyDTO) ;
        if(createdCompany != null && createdCompany.getId() != null)
            return new ResponseEntity<>(createdCompany,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PostMapping(path = "/{companyId}/deals")
    public ResponseEntity<DealDTO> createDeal(@PathVariable Long companyId, @RequestBody DealDTO deal){
        DealDTO createdDeal = dealService.saveDealOfCompany(deal,companyId);
        if(createdDeal != null && createdDeal.getId() != null)
            return new ResponseEntity<>(createdDeal,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
