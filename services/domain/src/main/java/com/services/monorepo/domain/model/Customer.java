package com.services.monorepo.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
}
