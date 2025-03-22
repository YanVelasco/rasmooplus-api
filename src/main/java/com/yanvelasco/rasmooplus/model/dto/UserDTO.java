package com.yanvelasco.rasmooplus.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UserDTO(

        Long id,

        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Phone cannot be blank")
        @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
        @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Phone number must be in the format (XX) " +
                "XXXX-XXXX or (XX) XXXXX-XXXX")
        String phone,

        @NotBlank(message = "CPF cannot be blank")
        @CPF(message = "Invalid CPF format")
        String cpf,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dtSubscription,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dtExpiration,

        @NotNull(message = "User type cannot be null")
        Long userTypeId,

        Long subscriptionTypeId

) {
}