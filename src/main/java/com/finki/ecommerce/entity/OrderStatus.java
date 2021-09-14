package com.finki.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="order_status")
@Getter
@Setter
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="os_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="order_id")
    @PrimaryKeyJoinColumn(name="order_id", referencedColumnName = "id")
    private Order order; //OrderStatus is a weak entity. OrderStatus has an order that it is associated with

    @Column(name="status")
    private String status;

    @Column(name="last_updated")
    @CreationTimestamp
    private Date lastUpdated;

}
