package com.bookmx.api;

import com.bookmx.domain.Ciudad;
import com.bookmx.domain.Hotel;
import com.bookmx.repository.CiudadRepository;
import com.bookmx.repository.HotelRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/hoteles") @RequiredArgsConstructor
public class HotelController {
    private final HotelRepository hotelRepo;
    private final CiudadRepository ciudadRepo;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Hotel crear(@Valid @RequestBody Hotel h){
        // asegurar que la ciudad exista si viene solo el id
        if (h.getCiudad() != null && h.getCiudad().getId() != null) {
            Ciudad c = ciudadRepo.findById(h.getCiudad().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Ciudad no encontrada"));
            h.setCiudad(c);
        }
        return hotelRepo.save(h);
    }

    @GetMapping public List<Hotel> listar(){ return hotelRepo.findAll(); }
}
