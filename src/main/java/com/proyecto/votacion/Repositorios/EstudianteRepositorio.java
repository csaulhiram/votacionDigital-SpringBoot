package com.proyecto.votacion.Repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.proyecto.votacion.Objetos.EstudianteObjeto;


@Repository
public interface EstudianteRepositorio extends JpaRepository<EstudianteObjeto, String> {
    @Modifying
    @Query(value = "UPDATE estudiante e set e.estatus_voto = 1 where e.cta = ?", nativeQuery = true)
    void actualizarEstatus(String cta);

    @Procedure(procedureName = "getAlumnosVotos")
    ArrayList<EstudianteObjeto> faltantesVotar();


}
