package com.example.order_service;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repo;
    private final OrderService service;

    public OrderController(OrderRepository repo, OrderService service) {
        this.repo = repo;
        this.service = service;
    }

    @PostMapping
    public OrderEntity create(@RequestBody OrderEntity order) {
        return service.create(order);
    }

    @GetMapping
    public List<OrderEntity> all() {
        return repo.findAll();
    }

    // ✅ Inter-service demo endpoint:
    // returns user data for a given order
    @GetMapping("/{id}/user")
    public User userForOrder(@PathVariable Long id) {
        return service.getUserForOrder(id);
    }
}