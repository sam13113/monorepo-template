package com.services.monorepo.adapter.mapper;

import com.services.monorepo.adapter.entity.CustomerEntity;
import com.services.monorepo.adapter.mapper.config.CommonMappingConfig;
import com.services.monorepo.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(config = CommonMappingConfig.class)
public interface CustomerEntityDomainMapper {

    CustomerEntity mapToEntity(Customer customer);

    Customer mapToDomain(CustomerEntity customerEntity);
}
