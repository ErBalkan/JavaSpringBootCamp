package com.erbalkan.rentAcar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erbalkan.rentAcar.business.abstracts.BrandService;
import com.erbalkan.rentAcar.entities.concretes.Brand;

@RestController // api olduğunu bildirir.
@RequestMapping("/api/brands") // apiye erişim adresini bildirir.
public class BrandsController {
    private BrandService _brandService;

    @Autowired // parametreye bakar uygulamayı tarar ve parametreyi implemente edeni bulup new'lenmiş halini verir.
    public BrandsController(BrandService brandService) {
        _brandService = brandService;
    }

    @GetMapping("/getall")
    public List<Brand> getAll(){
        return _brandService.getAll();
    }
}