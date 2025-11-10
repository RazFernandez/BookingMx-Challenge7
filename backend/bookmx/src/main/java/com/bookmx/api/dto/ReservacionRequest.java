package com.bookmx.api.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ReservacionRequest(
        @NotNull Long hotelId,
        @NotBlank String nombreHuesped,
        @Email @NotBlank String email,
        @Positive int numPersonas,
        @NotNull LocalDate fechaInicio,
        @NotNull LocalDate fechaFin
) {}
