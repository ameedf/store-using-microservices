package com.ameed.api;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "orders")
public class Order extends BaseEntity {
    private Map<String, Integer> items;
    private Double total;
    private String userId;
    private OrderStatus status;
}
