package com.erbalkan.rentAcar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.erbalkan.rentAcar.business.requests.CreateBrandRequest;
import com.erbalkan.rentAcar.business.responses.GetAllBrandsResponse;
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
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = _brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();
        for (Brand brand : brands){
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponses.add(responseItem);
        }
        return brandsResponses;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this._brandRepository.save(brand);
    }

}
