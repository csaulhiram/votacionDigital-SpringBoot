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

    @Transactional
    public void eliminarPlanilla(String estudiante_cta) {
        planillaRepositorio.eliminarPlanilla(estudiante_cta);
    }

    @Transactional
    public void votarPlanilla(String id_planilla) {   
        

        Optional<PlanillaObjeto> planilla;
        planilla = planillaRepositorio.findById(id_planilla);

        Integer votos = (Integer) planilla.get().getVotos();
        if(votos == null) {
            votos = 0;
        } 
        votos++;

        planillaRepositorio.votarPlanillaRepo(votos, id_planilla);
    }
}
