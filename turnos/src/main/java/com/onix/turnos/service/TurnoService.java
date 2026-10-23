package com.onix.turnos.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import com.onix.turnos.client.PacienteClient;
import com.onix.turnos.dto.PacienteResponse;
import com.onix.turnos.dto.TurnoDTO;
import com.onix.turnos.entity.Turno;
import com.onix.turnos.repository.TurnosRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service 
public class TurnoService {
    private TurnosRepository turnoRepository;
    private PacienteClient pacienteClient;

    
    @Value("${pacientes.api.url}")
    private String pacientesApiUrl;  // http://localhost:9001
    
    public TurnoService(TurnosRepository turnoRepository, 
                       PacienteClient pacienteClient) {
        this.turnoRepository = turnoRepository;
        this.pacienteClient = pacienteClient;
    }
    
    @CircuitBreaker(name="pacientesService", fallbackMethod = "fallbackBuscarPaciente")
    public Turno guardarTurno(TurnoDTO turnoDTO) {
        // 1. Llamar a PACIENTES para validar que existe
        //String urlPaciente = pacientesApiUrl + "/api/pacientes/dni/" + turnoDTO.getDni();

        try {
            // Llamada HTTP GET
           // PacienteResponse paciente = restTemplate.getForObject(urlPaciente, PacienteResponse.class);
            PacienteResponse paciente = pacienteClient.buscarPorDni(turnoDTO.getDni());

            if (paciente != null) {
                // 2. Si existe, crear y guardar el turno
                Turno turno = new Turno();
                turno.setFecha(turnoDTO.getFecha());
                turno.setTratamiento(turnoDTO.getTratamiento());
                turno.setPacienteDni(turnoDTO.getDni());
                turno.setIdPaciente(paciente.getId());
                
                return turnoRepository.save(turno);
            }
        } catch (Exception e) {
            throw new RuntimeException("Paciente no encontrado con DNI: " + turnoDTO.getDni());
        }
        
        throw new RuntimeException("No se pudo procesar el turno");
    }

    public Turno fallbackBuscarPaciente(TurnoDTO turnoDTO, Exception e){
        throw new RuntimeException("Servicio de Pacientes no disponible. Intenta mas tarde");
    }

}
