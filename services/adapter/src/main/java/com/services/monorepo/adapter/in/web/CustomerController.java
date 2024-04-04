package com.services.monorepo.adapter.in.web;

import com.services.monorepo.adapter.mapper.CustomerDtoDomainMapper;
import com.services.monorepo.demo.api.CustomerApi;
import com.services.monorepo.demo.api.model.CustomerCreationRequestDto;
import com.services.monorepo.demo.api.model.CustomerCreationResponseDto;
import com.services.monorepo.domain.application.port.api.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerDtoDomainMapper customerDtoDomainMapper;
    @Override
    public ResponseEntity<CustomerCreationResponseDto> createCustomer(CustomerCreationRequestDto customerCreationRequestDto) {
        var customerCreated = createCustomerUseCase.createCustomer(customerDtoDomainMapper.creationRequestToDomain(customerCreationRequestDto));
        return null;
    }
}
