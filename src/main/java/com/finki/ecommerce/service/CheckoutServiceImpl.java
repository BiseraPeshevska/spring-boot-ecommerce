package com.finki.ecommerce.service;

import com.finki.ecommerce.dao.CustomerRepository;
import com.finki.ecommerce.dto.Purchase;
import com.finki.ecommerce.dto.PurchaseResponse;
import com.finki.ecommerce.entity.Customer;
import com.finki.ecommerce.entity.Order;
import com.finki.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        //populate order with billing and shipping address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);
        // save to the database
        customerRepository.save(customer);
        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // creates an unique ID that is hard to guess and is random
        // because i dont want to use the serial auto incremented id from db
        // UUID - Universally Unique Identifier - standardized methods for generating unique IDS
        // 103 trillion uuids version4; 0% probability for collision

        return UUID.randomUUID().toString(); // "078a4faf-0a58-4f2b-9707-b00200c5f707"
    }

}
