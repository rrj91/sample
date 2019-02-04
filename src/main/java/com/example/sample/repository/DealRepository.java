package com.example.sample.repository;


import com.example.sample.model.Company;
import com.example.sample.model.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends CrudRepository<Deal,Long> {

    Deal findByParentCompanyAndId(Company parentCompany,Long id);
}
