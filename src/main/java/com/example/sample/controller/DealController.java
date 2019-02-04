package com.example.sample.controller;

import com.example.sample.dto.DealDTO;
import com.example.sample.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/deals")
public class DealController {

    @Autowired
    private DealService dealService;

    @GetMapping
    public ResponseEntity<List<DealDTO>> findAll(){
        List<DealDTO> dealDTOS = dealService.getAll();
        if(dealDTOS != null && dealDTOS.size() > 0)
            return new ResponseEntity<>(dealDTOS, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "{dealId}")
    public ResponseEntity<DealDTO> findById(Long dealId){
        DealDTO dealDTO = dealService.getDealById(dealId);
        if(dealDTO != null)
            return new ResponseEntity<>(dealDTO,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
