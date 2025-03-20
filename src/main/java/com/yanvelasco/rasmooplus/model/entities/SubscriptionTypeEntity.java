package com.yanvelasco.rasmooplus.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriptions_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTypeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptions_type_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "access_months", nullable = false)
    private Long accessMonths;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "product_key", nullable = false)
    private String productKey;

}