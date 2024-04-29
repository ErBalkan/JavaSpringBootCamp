package com.erbalkan.rentAcar.business.concretes;

import com.erbalkan.rentAcar.business.abstracts.ModelService;
import com.erbalkan.rentAcar.business.responses.GetAllModelsResponse;
import com.erbalkan.rentAcar.core.utilities.mappers.ModelMapperService;
import com.erbalkan.rentAcar.dataAccess.abstracts.ModelRepository;
import com.erbalkan.rentAcar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository _modelRepository;
    private final ModelMapperService _modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = _modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream().map(model -> this._modelMapperService.forResponse()
                .map(model,GetAllModelsResponse.class)).toList();
        return modelsResponse;
    }
}
