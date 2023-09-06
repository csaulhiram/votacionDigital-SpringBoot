package com.proyecto.votacion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.votacion.Objetos.PlanillaObjeto;
import com.proyecto.votacion.Servicios.PlanillaServicio;

@RestController
@RequestMapping("/planillas")
public class PlanillaControlador {
    @Autowired
    PlanillaServicio planillaServicio;

    @PostMapping("registrarPlanilla")
    public PlanillaObjeto registrarPlanilla(@RequestBody PlanillaObjeto planillaInfo) {
        return planillaServicio.registrarPlanilla(planillaInfo);
    }

    @GetMapping("/obtenerPlanillas")
    public List<PlanillaObjeto> obtenerPlanillas() {
        return planillaServicio.obtenerPlanillas();
    }

    @DeleteMapping("/elimnarPlanilla")
    public void elimnarPlanilla(@RequestParam String cta) {
        planillaServicio.eliminarPlanilla(cta);
    }

    @PutMapping("/votar")
    public void votar(@RequestParam String id_planilla) {
        planillaServicio.votar(id_planilla);
    }
}
