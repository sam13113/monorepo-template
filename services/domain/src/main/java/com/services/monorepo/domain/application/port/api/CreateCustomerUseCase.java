package com.services.monorepo.domain.application.port.api;

import com.services.monorepo.domain.model.Customer;

public interface CreateCustomerUseCase {
    Customer createCustomer(Customer customer);
}
