package com.yanvelasco.rasmooplus.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "user_payment_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPaymentInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_payment_info_id")
    private Long id;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_expiration_month", nullable = false)
    private Long cardExpirationMonth;

    @Column(name = "card_expiration_year", nullable = false)
    private Long cardExpirationYear;

    @Column(name = "card_security_code", nullable = false)
    private String cardSecurityCode;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "instalments", nullable = false)
    private Long instalments;

    @Column(name = "dt_payment", nullable = false)
    private String dtPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

}
