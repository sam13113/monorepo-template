package com.services.monorepo.adapter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "customers")
@Data
@NoArgsConstructor
public class CustomerEntity {

    @Id
    private String id;
    private String firstName;
    private String lastName;
}
