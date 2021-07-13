package com.finki.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber; // final because Lombok will create constructor automatically for final fields
}
