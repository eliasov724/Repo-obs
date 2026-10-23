package com.onix.turnos.client;
import com.onix.turnos.dto.PacienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacientes")
public interface PacienteClient {

    @GetMapping ("api/pacientes/dni/{dni}")
        PacienteResponse buscarPorDni(@PathVariable String dni);
    
    
} 
