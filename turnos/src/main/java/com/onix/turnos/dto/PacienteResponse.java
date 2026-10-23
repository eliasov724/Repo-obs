package com.onix.turnos.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private List<String> telefonos;
}
