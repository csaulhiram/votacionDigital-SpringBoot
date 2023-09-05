package com.proyecto.votacion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
/* import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; */
import org.springframework.stereotype.Repository;

//import com.proyecto.votacion.DTO.EstudianteDTO;
import com.proyecto.votacion.Objetos.EstudianteObjeto;

@Repository
public interface EstudianteRepositorio extends JpaRepository<EstudianteObjeto, String> {

    /* @Query("UPDATE com.proyecto.votacion.DTO.EstudianteDTO SET estatus_voto = 1 WHERE cta = ?cta")   
    void actualizarEstatus(@Param("cta") String cta); */

    /* @Query("UPDATE estudiante SET estatus_voto = 1 WHERE cta = 'estudiante1'")   
    void actualizarEstatus(@Param("cta") String cta); */
}
