package com.services.monorepo.domain.application.port.spi;

import com.services.monorepo.domain.model.Customer;

/**
 * Event-port for sending customer event.
 * */
public interface CustomerEventPort {

    /**
     * Sends {@link Customer} model to output.
     * */
    void sendCustomerEvent(Customer customer);
}
