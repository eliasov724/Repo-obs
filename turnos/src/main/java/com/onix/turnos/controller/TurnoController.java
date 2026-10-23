package com.onix.turnos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onix.turnos.dto.TurnoDTO;
import com.onix.turnos.entity.Turno;
import com.onix.turnos.repository.TurnosRepository;
import com.onix.turnos.service.TurnoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/turnos")
public class TurnoController {
    
    private TurnoService turnoService;

    public TurnoController (TurnoService turnoService) {
        this.turnoService = turnoService;

    }


    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        try {
            Turno turnoGuardado = turnoService.guardarTurno(turnoDTO);
            return ResponseEntity.ok(turnoGuardado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

}
