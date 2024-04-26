package com.erbalkan.rentAcar.webApi.controllers;

import java.util.List;

import com.erbalkan.rentAcar.business.requests.CreateBrandRequest;
import com.erbalkan.rentAcar.business.requests.UpdateBrandRequest;
import com.erbalkan.rentAcar.business.responses.GetAllBrandsResponse;
import com.erbalkan.rentAcar.business.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.erbalkan.rentAcar.business.abstracts.BrandService;

@RestController // api olduğunu bildirir.
@RequestMapping("/api/brands") // apiye erişim adresini bildirir.
public class BrandsController {
    private final BrandService _brandService;

    @Autowired // parametreye bakar uygulamayı tarar ve parametreyi implemente edeni bulup new'lenmiş halini verir.
    public BrandsController(BrandService brandService) {
        _brandService = brandService;
    }

    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll(){
        return _brandService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED) // işlem başarılı olduğunda 201 döndürmesi için.
    public void add(CreateBrandRequest createBrandRequest){
        _brandService.add(createBrandRequest);
    }

    @GetMapping("/getbyid/{id}") // süslü paranteze alınca değişken değeri olmuş olur.
    // @PathVariable urlden değişkeni al.
    public GetByIdBrandResponse getById(@PathVariable int id){
        return this._brandService.getById(id);
    }

    @PutMapping("/update")
    public void update(UpdateBrandRequest updateBrandRequest){
        this._brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this._brandService.delete(id);
    }
}
