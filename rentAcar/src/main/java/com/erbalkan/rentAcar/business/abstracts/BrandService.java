package com.erbalkan.rentAcar.business.abstracts;

import java.util.List;

import com.erbalkan.rentAcar.entities.concretes.Brand;

public interface BrandService {
    List<Brand> getAll();
}
