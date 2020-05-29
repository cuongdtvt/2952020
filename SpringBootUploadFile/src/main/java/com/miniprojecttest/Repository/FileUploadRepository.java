package com.miniprojecttest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniprojecttest.Entity.PrimeMinisterOfIndia;

@Repository
public interface FileUploadRepository extends 
JpaRepository<PrimeMinisterOfIndia, Integer>{

}
