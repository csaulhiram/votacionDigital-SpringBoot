package com.proyecto.votacion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.votacion.Objetos.InfoUsuarioObjeto;


@Repository
public interface InfoUsuarioRepositorio extends JpaRepository<InfoUsuarioObjeto, String>{
    
}
