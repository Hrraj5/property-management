package com.myproperty.propertymanagement.repository;

import com.myproperty.propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}
