package com.services.monorepo.domain.application.service;

import com.services.monorepo.domain.application.port.api.CreateCustomerUseCase;
import com.services.monorepo.domain.application.port.spi.CustomerEventPort;
import com.services.monorepo.domain.application.port.spi.CustomerPersistencePort;
import com.services.monorepo.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link CreateCustomerUseCase}.
 * */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService implements CreateCustomerUseCase {

    private final CustomerPersistencePort customerPersistencePort;
    private final CustomerEventPort customerEventPort;

    /**
     * {@inheritDoc}
     * */
    @Override
    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerPersistencePort.storeNewCustomer(customer);
        log.info("Saved customer with id {}", savedCustomer.getId());
        customerEventPort.sendCustomerEvent(savedCustomer);
        return savedCustomer;
    }
}
