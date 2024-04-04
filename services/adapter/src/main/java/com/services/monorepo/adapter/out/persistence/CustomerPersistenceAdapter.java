package com.services.monorepo.adapter.out.persistence;

import com.services.monorepo.adapter.mapper.CustomerEntityDomainMapper;
import com.services.monorepo.adapter.repository.CustomerRepository;
import com.services.monorepo.domain.application.port.spi.CustomerPersistencePort;
import com.services.monorepo.domain.model.Customer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements CustomerPersistencePort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityDomainMapper customerEntityDomainMapper;

    @Override
    public Customer storeNewCustomer(Customer customer) {
        var entity = customerEntityDomainMapper.mapToEntity(customer);
        var createdEntity = customerRepository.insert(entity);
        return customerEntityDomainMapper.mapToDomain(createdEntity);
    }
}
