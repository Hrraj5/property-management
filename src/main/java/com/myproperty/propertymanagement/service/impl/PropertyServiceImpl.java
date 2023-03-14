package com.myproperty.propertymanagement.service.impl;

import com.myproperty.propertymanagement.converter.PropertyConverter;
import com.myproperty.propertymanagement.dto.PropertyDTO;
import com.myproperty.propertymanagement.entity.PropertyEntity;
import com.myproperty.propertymanagement.repository.PropertyRepository;
import com.myproperty.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO prop) {
        System.out.println("Inside save service");
        PropertyEntity pe = propertyConverter.convertDtoToEntity(prop);
        pe = propertyRepository.save(pe);
        prop = propertyConverter.convertEntityToDTO(pe);
        return prop;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> entities = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        for(PropertyEntity e : entities){
            propertyDTOS.add(propertyConverter.convertEntityToDTO(e));
        }
        return propertyDTOS;
    }

    @Override
    public PropertyDTO updatePropertyDto(PropertyDTO prop, Long id) {
        Optional<PropertyEntity> entity = propertyRepository.findById(id);
        PropertyEntity savedEntity  =  null;
        if(entity.isPresent()) {
            savedEntity = entity.get();
            savedEntity.setTitle(prop.getTitle());
            savedEntity.setDescription(prop.getDescription());
            savedEntity.setAddress(prop.getAddress());
            savedEntity.setPrice(prop.getPrice());
            savedEntity.setOwnerEmail(prop.getOwnerEmail());
            savedEntity.setOwnerName(prop.getOwnerName());
        }
        savedEntity = propertyRepository.save(savedEntity);
        return propertyConverter.convertEntityToDTO(savedEntity);
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO prop, Long id) {
        Optional<PropertyEntity> entity = propertyRepository.findById(id);
        PropertyEntity savedEntity  =  null;
        if(entity.isPresent()) {
            savedEntity = entity.get();
            savedEntity.setDescription(prop.getDescription());
        }
        savedEntity = propertyRepository.save(savedEntity);
        return propertyConverter.convertEntityToDTO(savedEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<PropertyEntity> entity = propertyRepository.findById(id);
        if(entity.isPresent()) {
            propertyRepository.deleteById(id);
            System.out.println("Deleted Successfully");
        }
    }
}
