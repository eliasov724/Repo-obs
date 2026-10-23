package com.onix.turnos.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "turnos")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Turno {

@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false)
private String fecha;

@Column (nullable = false)
private String tratamiento;

@Column(nullable = false)
private String pacienteDni;  // Guardamos el DNI del paciente que existe en pacientes_db
    
@Column(nullable = false)
private Long idPaciente;     // También guardamos el ID que nos retornó pacientes
}