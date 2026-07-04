package com.telusko.springecom.entity.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {
}
