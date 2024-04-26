package com.erbalkan.rentAcar.business.concretes;

import java.util.List;

import com.erbalkan.rentAcar.business.requests.CreateBrandRequest;
import com.erbalkan.rentAcar.business.requests.UpdateBrandRequest;
import com.erbalkan.rentAcar.business.responses.GetAllBrandsResponse;
import com.erbalkan.rentAcar.business.responses.GetByIdBrandResponse;
import com.erbalkan.rentAcar.core.utilities.mappers.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erbalkan.rentAcar.business.abstracts.BrandService;
import com.erbalkan.rentAcar.dataAccess.abstracts.BrandRepository;
import com.erbalkan.rentAcar.entities.concretes.Brand;

@Service // Bu sınıf bir business nesnesidir.
// @AllArgsConstructor // Dependency Injection için kullanabilirsin.
public class BrandManager implements BrandService {

    private final BrandRepository _brandRepository;
    private final ModelMapperService _modelMapperService;
    
    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
        _brandRepository = brandRepository;
        _modelMapperService = modelMapperService;
    }
    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = _brandRepository.findAll();
//        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();
//        for (Brand brand : brands){
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setId(brand.getId());
//            responseItem.setName(brand.getName());
//            brandsResponses.add(responseItem);
//        }

        return brands.stream().map(brand -> this._modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).toList();

    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this._brandRepository.findById(id).orElseThrow();
        return this._modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());

        Brand brand = this._modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        // Bir brand nesnesi oluşturduk daha sonra mapperi kullanarak createBrandRequest nesnesini Brand nesnesine map ettik.
        this._brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this._modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this._brandRepository.save(brand); // id'de istediğimiz için save metodu update yapmış olacak.
    }

    @Override
    public void delete(int id) {
        this._brandRepository.deleteById(id);
    }

}
