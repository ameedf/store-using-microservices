package com.ameed.api;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String street;
    private String phone;
    private boolean manager;
}
