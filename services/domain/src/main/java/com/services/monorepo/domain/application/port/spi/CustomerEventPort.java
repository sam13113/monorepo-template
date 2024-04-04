package com.services.monorepo.domain.application.port.spi;

import com.services.monorepo.domain.model.Customer;

public interface CustomerEventPort {

    void sendCustomerEvent(Customer customer);
}
