package com.bookmx.api;

import com.bookmx.api.dto.ReservacionRequest;
import com.bookmx.domain.Reservacion;
import com.bookmx.repository.ReservacionRepository;
import com.bookmx.service.ReservacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/reservaciones") @RequiredArgsConstructor
public class ReservacionController {
    private final ReservacionService service;
    private final ReservacionRepository repo;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Reservacion crear(@Valid @RequestBody ReservacionRequest request){
        return service.crear(request);
    }

    @GetMapping public List<Reservacion> listar(){ return repo.findAll(); }
}
