package com.proyecto.votacion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.votacion.Objetos.PlanillaObjeto;
import com.proyecto.votacion.Servicios.PlanillaServicio;

@RestController
@RequestMapping("/planillas")
public class PlanillaControlador {
    @Autowired
    PlanillaServicio planillaServicio;

    @PostMapping(path = "/registrarPlanilla", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public PlanillaObjeto registrarPlanilla(PlanillaObjeto planillaInfo) {
        return planillaServicio.registrarPlanilla(planillaInfo);
    }

    @GetMapping("/obtenerPlanillas")
    public List<PlanillaObjeto> obtenerPlanillas() {
        return planillaServicio.obtenerPlanillas();
    }

    @DeleteMapping("/elimnarPlanilla")
    @CrossOrigin()
    public void elimnarPlanilla(String estudiante_cta) {
        planillaServicio.eliminarPlanilla(estudiante_cta);
    }

    @PutMapping(path = "/votar", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @CrossOrigin()
    public void votar(String id_planilla) {
        planillaServicio.votarPlanilla(id_planilla);
    }
}
