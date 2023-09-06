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

import com.proyecto.votacion.Objetos.EstudianteObjeto;
import com.proyecto.votacion.Servicios.EstudianteServicio;

@RestController
@RequestMapping("/estudiante")
public class EstudianteControlador {
    @Autowired
    EstudianteServicio estudianteServicio;

    @PostMapping("/registrarEstudiante")
    public EstudianteObjeto registrarAdmin(@RequestBody EstudianteObjeto estudianteObjeto) {

        return estudianteServicio.registrarEstudiante(estudianteObjeto);
    }

    @PutMapping("/modificarEstudiante")
    public EstudianteObjeto modificarUsuario(@RequestBody EstudianteObjeto data) {
        return estudianteServicio.actualizarEstudiante(data);
    }

    @GetMapping("/obtenerEstudiantes")
    public List<EstudianteObjeto> obtenerAdmin() {
        return estudianteServicio.obtenerEstudiantes();
    }

    @DeleteMapping("/eliminarEstudiante")
    public void eliminarAdmin(@RequestParam String id) {
        estudianteServicio.eliminarEstudiante(id);
    }

    @PutMapping("/estatus_voto")
    public void estatusVoto(@RequestParam String cta) {
        estudianteServicio.modificarEstatus_voto(cta);
    }

}
