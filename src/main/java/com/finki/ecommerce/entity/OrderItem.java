package com.finki.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_item")
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="o_id")
    private Integer id; // diskriminator

    @ManyToOne
    @JoinColumn(name="order_id")
    @PrimaryKeyJoinColumn(name="order_id", referencedColumnName = "id")
    private Order order; //OrderItem is a weak entity. It has an order that it is associated with

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="unit_price")
    private BigDecimal unitPrice;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="product_id")
    private Integer productId;

}
