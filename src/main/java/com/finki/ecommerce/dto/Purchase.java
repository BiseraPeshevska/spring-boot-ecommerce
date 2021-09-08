package com.finki.ecommerce.dto;

import com.finki.ecommerce.entity.Address;
import com.finki.ecommerce.entity.Customer;
import com.finki.ecommerce.entity.Order;
import com.finki.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
