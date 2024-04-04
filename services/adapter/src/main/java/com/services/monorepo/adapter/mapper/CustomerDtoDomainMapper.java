package com.services.monorepo.adapter.mapper;

import com.services.monorepo.adapter.mapper.config.CommonMappingConfig;
import com.services.monorepo.demo.api.model.CustomerCreationRequestDto;
import com.services.monorepo.demo.api.model.CustomerCreationResponseDto;
import com.services.monorepo.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMappingConfig.class)
public interface CustomerDtoDomainMapper {

   Customer creationRequestToDomain(CustomerCreationRequestDto customerCreationRequestDto);

   @Mapping(source = "id", target = "customerId")
   CustomerCreationResponseDto domainToResponseDto(Customer customer);
}
