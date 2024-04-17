package com.erbalkan.rentAcar.dataAccess.abstracts.concretes;

import java.util.List;

import com.erbalkan.rentAcar.entities.concretes.Brand;

public interface BrandRepository {
    List<Brand> getAll();
}
