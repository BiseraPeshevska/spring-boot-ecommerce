package com.finki.ecommerce.dao;

import com.finki.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// Not annotated, hence will not be exposed to rest api/customers
//@RepositoryRestResource
public interface CustomerRepository extends JpaRepository <Customer, Integer>{

    // Behind the scenes Spring will execute query similar to this:
    // select * from customer where email = theEmail
    Customer findByEmail(String theEmail);

}
