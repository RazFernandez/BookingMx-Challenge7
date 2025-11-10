package com.bookmx.api;

import com.bookmx.domain.Ciudad;
import com.bookmx.repository.CiudadRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/ciudades") @RequiredArgsConstructor
public class CiudadController {
    private final CiudadRepository repo;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Ciudad crear(@Valid @RequestBody Ciudad c){ return repo.save(c); }

    @GetMapping public List<Ciudad> listar(){ return repo.findAll(); }
}
