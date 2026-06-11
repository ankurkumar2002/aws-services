package com.example.order_service;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String item;
    private Integer qty;

    public OrderEntity() {}

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getItem() { return item; }
    public Integer getQty() { return qty; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setItem(String item) { this.item = item; }
    public void setQty(Integer qty) { this.qty = qty; }
}
