package com.ameed.orders;

import com.ameed.api.Order;
import com.ameed.api.OrderStatus;
import com.ameed.api.Product;
import com.ameed.api.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {
    private final List<Product> products;
    private final RestTemplate restTemplate;
    private final OrderRepository orderRepository;

    public OrderService(RestTemplate restTemplate,
                        OrderRepository orderRepository) {
        this.restTemplate = restTemplate;
        this.orderRepository = orderRepository;
        products = new LinkedList<>();
    }

    public Order createOrder(Order newOrder) {
        User user = restTemplate.getForObject(
                "http://user-service/users/" + newOrder.getUserId(),
                User.class);
        if (user == null) {
            throw new IllegalArgumentException("invalid user id");
        }
        newOrder.setItems(new HashMap<>());
        newOrder.setTotal(0.0);
        newOrder.setStatus(OrderStatus.NEW);
        return orderRepository.save(newOrder);
    }
}
