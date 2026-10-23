package com.onix.pacientes.controller;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onix.pacientes.entity.Paciente;
import com.onix.pacientes.service.PacienteService;


@RestController 
@RequestMapping("/api/pacientes")
public class PacienteController {
    
private PacienteService pacService;

public PacienteController (PacienteService pacService){
    this.pacService = pacService;
}

@PostMapping
public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
    Paciente guardado = pacService.crearPaciente(paciente);
    return ResponseEntity.ok(guardado);
}

@GetMapping("/dni/{dni}")
public ResponseEntity<Paciente> pacientedevolver(@PathVariable String dni) {
    Optional<Paciente> paciente = pacService.buscarPorDni(dni);

    if (paciente.isPresent()){
        return ResponseEntity.ok(paciente.get());
    } else {
        return ResponseEntity.notFound().build();
    }

}


}
