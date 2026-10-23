package com.onix.pacientes.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor 

@Entity 
@Table(name = "pacientes")
@Data 
public class Paciente {

@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String nombre;

@Column (nullable = false)
private String apellido;
@Column (nullable = false, unique = true)
private String dni;
@Column (nullable = false)
private String email;

@ElementCollection 
private List<String> telefonos;

}