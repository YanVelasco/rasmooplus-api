package com.yanvelasco.rasmooplus.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriptions_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class SubscriptionTypeEntity extends RepresentationModel<SubscriptionTypeEntity> implements Serializable {

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

    @Column(name = "product_key", nullable = false, unique = true)
    private String productKey;

}