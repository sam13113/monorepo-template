package com.services.monorepo.domain.application.port.api;

import com.services.monorepo.domain.model.Customer;

/**
 * Usecase for customer-creation.
 * */
public interface CreateCustomerUseCase {

    /**
     * Holds logic for creating a {@link Customer}.
     *
     * @params customer.
     * @return customer.
     * */
    Customer createCustomer(Customer customer);
}
