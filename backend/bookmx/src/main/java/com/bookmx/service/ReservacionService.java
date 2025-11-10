package com.bookmx.service;

import com.bookmx.api.dto.ReservacionRequest;
import com.bookmx.domain.*;
import com.bookmx.repository.*;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class ReservacionService {
    private final HotelRepository hotelRepo;
    private final ReservacionRepository reservacionRepo;

    @Transactional
    public Reservacion crear(ReservacionRequest req) {
        if (!req.fechaFin().isAfter(req.fechaInicio()))
            throw new ValidationException("fechaFin debe ser posterior a fechaInicio");

        Hotel hotel = hotelRepo.findById(req.hotelId())
                .orElseThrow(() -> new IllegalArgumentException("Hotel no encontrado"));

        Reservacion r = Reservacion.builder()
                .hotel(hotel)
                .nombreHuesped(req.nombreHuesped())
                .email(req.email())
                .numPersonas(req.numPersonas())
                .fechaInicio(req.fechaInicio())
                .fechaFin(req.fechaFin())
                .build();

        return reservacionRepo.save(r);
    }
}
