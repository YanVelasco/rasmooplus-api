package com.yanvelasco.rasmooplus.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SubscriptionTypeUpdateDTO(
        String name,
        Long accessMonths,
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
        BigDecimal price,
        @Size(max = 255, message = "Product key cannot exceed 255 characters")
        String productKey
) {
}