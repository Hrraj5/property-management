package com.myproperty.propertymanagement.service;

import com.myproperty.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
     PropertyDTO saveProperty(PropertyDTO prop);
     List<PropertyDTO> getAllProperties();
     PropertyDTO updatePropertyDto(PropertyDTO prop, Long id);
    PropertyDTO updateDescription(PropertyDTO prop, Long id);
    void delete(Long id);
}
