package com.proyecto.votacion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.votacion.Objetos.PlanillaObjeto;

@Repository
public interface PlanillaRepositorio extends JpaRepository<PlanillaObjeto, String> {
    @Modifying
    @Query(value = "UPDATE planilla p set p.votos = ? where p.id_planilla = ?", nativeQuery = true)
    void votar(Integer votos, String id_planilla);
}
