package org.acme.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ModelMapperBean {
    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
