package com.erbalkan.rentAcar.business.abstracts;

import java.util.List;

import com.erbalkan.rentAcar.business.requests.CreateBrandRequest;
import com.erbalkan.rentAcar.business.requests.UpdateBrandRequest;
import com.erbalkan.rentAcar.business.responses.GetAllBrandsResponse;
import com.erbalkan.rentAcar.business.responses.GetByIdBrandResponse;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
