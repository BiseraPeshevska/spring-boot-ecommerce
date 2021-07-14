package com.finki.ecommerce.dao;

import com.finki.ecommerce.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // behind the scenes Spring boot will execute query similar to this:
    // select * from orders
    // left join customer
    // on orders.customerId = customer.id
    // where customer.email = email
    Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);
}
