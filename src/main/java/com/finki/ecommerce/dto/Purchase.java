package com.finki.ecommerce.dto;

import com.finki.ecommerce.entity.*;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
    private Set<OrderStatus> orderStatuses;
}
