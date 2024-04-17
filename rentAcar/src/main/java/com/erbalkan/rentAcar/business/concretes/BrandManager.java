package com.erbalkan.rentAcar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erbalkan.rentAcar.business.abstracts.BrandService;
import com.erbalkan.rentAcar.dataAccess.abstracts.concretes.BrandRepository;
import com.erbalkan.rentAcar.entities.concretes.Brand;

@Service // Bu sınıf bir business nesnesidir.
public class BrandManager implements BrandService {

    private BrandRepository _brandRepository;
    
    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        _brandRepository = brandRepository;
    }
    @Override
    public List<Brand> getAll() {
        return _brandRepository.getAll();
    }

}
