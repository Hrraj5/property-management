package com.myproperty.propertymanagement.converter;

import com.myproperty.propertymanagement.dto.PropertyDTO;
import com.myproperty.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDtoToEntity(PropertyDTO prop){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(prop.getTitle());
        pe.setDescription(prop.getDescription());
        pe.setAddress(prop.getAddress());
        pe.setPrice(prop.getPrice());
        pe.setOwnerEmail(prop.getOwnerEmail());
        pe.setOwnerName(prop.getOwnerName());
        return pe;
    }
    public PropertyDTO convertEntityToDTO(PropertyEntity entity){
        PropertyDTO dto = new PropertyDTO();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setAddress(entity.getAddress());
        dto.setPrice(entity.getPrice());
        dto.setOwnerEmail(entity.getOwnerEmail());
        dto.setOwnerName(entity.getOwnerName());
        return dto;
    }
}
