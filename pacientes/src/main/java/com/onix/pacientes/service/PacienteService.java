package com.onix.pacientes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.onix.pacientes.entity.Paciente;
import com.onix.pacientes.repository.PacienteRepository;

@Service
public class PacienteService {
    
private PacienteRepository pacienteRepo;


public PacienteService (PacienteRepository pacienteRepo){
    this.pacienteRepo = pacienteRepo;
}

public Paciente crearPaciente(Paciente paciente) {
    return pacienteRepo.save(paciente);
}

public Optional<Paciente> buscarPorDni (String dni){
    return pacienteRepo.findByDni(dni);
}

}
