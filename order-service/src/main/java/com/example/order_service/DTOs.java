package com.example.order_service;

 record CreateOrderRequest(Long userId, String item, Integer qty) {}
 record UserDto(Long id, String name, String email) {}
 record DTOs(Long orderId, Long userId, String userName, String item, Integer qty) {}
