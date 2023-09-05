package com.proyecto.votacion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.votacion.Objetos.AdminObjeto;

@Repository
public interface AdminRepositorio extends JpaRepository<AdminObjeto, String>{
    
}
