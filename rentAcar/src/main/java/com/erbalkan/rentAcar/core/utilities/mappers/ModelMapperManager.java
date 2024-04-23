package com.erbalkan.rentAcar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
    private final ModelMapper _modelMapper;

    @Override
    public ModelMapper forResponse() {
        this._modelMapper
                .getConfiguration()
                .setAmbiguityIgnored(true) // Belirsizlik durumunda hata vermemesi için true
                .setMatchingStrategy(MatchingStrategies.LOOSE); // Her özelliğin maplenmesi şart değil.
        return this._modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this._modelMapper
                .getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD); // REQUEST metodunda her özelliğin maplenmesi için STANDARD
        return this._modelMapper;
    }
}
