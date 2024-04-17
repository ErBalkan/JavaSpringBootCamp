package com.erbalkan.rentAcar.dataAccess.abstracts.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.erbalkan.rentAcar.entities.concretes.Brand;

@Repository // Bu sınıf bir dataaccess nesnesidir.
public class InMemoryBrandRepository implements BrandRepository{

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"BMW"));
        brands.add(new Brand(2,"Mercedes"));
        brands.add(new Brand(3,"Audi"));
        brands.add(new Brand(4,"Fiat"));
        brands.add(new Brand(5,"Renault"));
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }

}
