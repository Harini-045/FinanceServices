package com.example.GenAi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GenAi.entity.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax,Long>{
    
}
