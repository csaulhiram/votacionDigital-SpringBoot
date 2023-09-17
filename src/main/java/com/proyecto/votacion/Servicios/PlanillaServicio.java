package com.proyecto.votacion.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.votacion.Objetos.PlanillaObjeto;
import com.proyecto.votacion.Repositorios.PlanillaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class PlanillaServicio {
    @Autowired
    PlanillaRepositorio planillaRepositorio;
    PlanillaObjeto planillaObjeto = new PlanillaObjeto();

    public PlanillaObjeto registrarPlanilla(PlanillaObjeto planillaData) {

        if (planillaRepositorio.existsById(planillaData.getId_planilla())) {
            return planillaObjeto;
        } else {
            return planillaRepositorio.save(planillaData);
        }
    }

    public List<PlanillaObjeto> obtenerPlanillas() {
        return planillaRepositorio.findAll();
    }

    public void eliminarPlanilla(String id) {
        planillaRepositorio.deleteById(id);
    }

    @Transactional
    public void votar(String id_planilla) {

        // validar si usuario votó

        Optional<PlanillaObjeto> planilla;
        planilla = planillaRepositorio.findById(id_planilla);
        Integer votos = (Integer) planilla.get().getVotos();
        votos++;
        planillaRepositorio.votar(votos, id_planilla);
     }
}
