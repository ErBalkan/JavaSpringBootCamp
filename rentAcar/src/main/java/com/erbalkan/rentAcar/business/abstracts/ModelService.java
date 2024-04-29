package com.erbalkan.rentAcar.business.abstracts;

import com.erbalkan.rentAcar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
}
