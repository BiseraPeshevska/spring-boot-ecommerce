package com.finki.ecommerce.service;

import com.finki.ecommerce.dto.Purchase;
import com.finki.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
