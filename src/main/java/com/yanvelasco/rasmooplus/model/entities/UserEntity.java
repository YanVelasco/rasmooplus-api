package com.yanvelasco.rasmooplus.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "dt_subscription", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dtSubscription;

    @Column(name = "dt_expiration", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dtExpiration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type_id")
    private UserTypeEntity userType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriptions_type_id")
    private SubscriptionTypeEntity subscriptionType;

    @PrePersist
    public void prePersist() {
        if (dtSubscription == null) {
            dtSubscription = LocalDate.now();
        }
        if (dtExpiration == null) {
            dtExpiration = dtSubscription.plusYears(1);
        }
    }

}