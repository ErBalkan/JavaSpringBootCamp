package com.erbalkan.rentAcar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erbalkan.rentAcar.entities.concretes.Brand;

// Integer- id primary key veri tipi
public interface BrandRepository extends JpaRepository<Brand,Integer>{
    // List<Brand> getAll(); // artık gerek yok şünkü JPA bütün crud metotlarını bize sunuyor.
}
