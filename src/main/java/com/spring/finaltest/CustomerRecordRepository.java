package com.spring.finaltest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.finaltest.CustomerRecord;

@Repository
public interface CustomerRecordRepository extends CrudRepository<CustomerRecord, Integer> {
    
}
