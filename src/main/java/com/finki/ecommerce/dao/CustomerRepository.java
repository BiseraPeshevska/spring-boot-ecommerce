package com.finki.ecommerce.dao;

import com.finki.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository <Customer, Integer>{
}
