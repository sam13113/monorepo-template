package com.services.monorepo.domain.application.port.spi;

import com.services.monorepo.domain.model.Customer;

/**
 * Port for interacting with Persistence layer.
 * */
public interface CustomerPersistencePort {

    /**
     * Adds {@link Customer} to persistence.
     *
     * @params customer.
     * @return customer.
     * */
    Customer storeNewCustomer(Customer customer);
}
