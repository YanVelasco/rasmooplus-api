package com.yanvelasco.rasmooplus.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SubscriptionTypeDTO(
        Long id,
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 255, message = "Name cannot exceed 255 characters")
        String name,
        @NotNull(message = "Access months cannot be null")
        Long accessMonths,
        @NotNull(message = "Price cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
        BigDecimal price,
        @Size(max = 255, message = "Product key cannot exceed 255 characters")
        String productKey
) {
}