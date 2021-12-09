package com.ameed.api;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product extends BaseEntity {
    private String name;
    private Double price;
    private Integer availableItems;
}
