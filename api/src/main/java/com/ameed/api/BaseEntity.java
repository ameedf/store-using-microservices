package com.ameed.api;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseEntity {
    @Id
    private String id;
}
