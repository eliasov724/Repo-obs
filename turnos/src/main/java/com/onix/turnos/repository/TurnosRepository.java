package com.onix.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onix.turnos.entity.Turno;

@Repository 
public interface TurnosRepository extends JpaRepository<Turno,Long>  {

    
} 