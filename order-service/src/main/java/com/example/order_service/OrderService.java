package com.example.order_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final OrderRepository repo;
    private final RestTemplate restTemplate;

    @Value("${user.service.baseUrl}")
    private String userServiceBaseUrl;

    public OrderService(OrderRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public OrderEntity create(OrderEntity order) {
        // 1) Call user-service to check user exists
        String url = userServiceBaseUrl + "/users/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);

        if (user == null) {
            throw new RuntimeException("User not found: " + order.getUserId());
        }

        // 2) Save order
        return repo.save(order);
    }

    public User getUserForOrder(Long orderId) {
        OrderEntity order = repo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));

        String url = userServiceBaseUrl + "/users/" + order.getUserId();
        return restTemplate.getForObject(url, User.class);
    }
}