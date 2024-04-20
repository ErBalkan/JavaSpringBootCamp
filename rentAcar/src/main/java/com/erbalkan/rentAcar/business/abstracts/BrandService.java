package com.erbalkan.rentAcar.business.abstracts;

import java.util.List;

import com.erbalkan.rentAcar.business.requests.CreateBrandRequest;
import com.erbalkan.rentAcar.business.responses.GetAllBrandsResponse;
import com.erbalkan.rentAcar.entities.concretes.Brand;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
}
