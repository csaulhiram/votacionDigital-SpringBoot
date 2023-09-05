package com.proyecto.votacion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.votacion.Objetos.PlanillaObjeto;

@Repository
public interface PlanillaRepositorio extends JpaRepository<PlanillaObjeto, String>{
    
}
