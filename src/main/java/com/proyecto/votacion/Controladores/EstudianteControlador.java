package com.proyecto.votacion.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PostMapping(path = "/registrarEstudiante", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public EstudianteObjeto registrarAdmin(EstudianteObjeto estudianteObjeto) {
        return estudianteServicio.registrarEstudiante(estudianteObjeto);
    }

    @PutMapping("/modificarEstudiante")
    public EstudianteObjeto modificarUsuario(@RequestBody EstudianteObjeto data) {
        return estudianteServicio.actualizarEstudiante(data);
    }

    @GetMapping("/obtenerEstudiantes")
    public List<EstudianteObjeto> obtenerEstudiantes() {
        return estudianteServicio.obtenerEstudiantes();
    }

   @DeleteMapping("/eliminarEstudiante")
    @CrossOrigin
    public void eliminarAdmin(String id) {
        estudianteServicio.eliminarEstudiante(id);
    }

    @PutMapping(path = "/estatus_voto", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @CrossOrigin
    public void estatusVoto(String cta) {
        estudianteServicio.modificarEstatus_voto(cta);
    }

    @GetMapping(path = "/obtenerEstudiantePorCTA", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @CrossOrigin
    public Optional<EstudianteObjeto> obtenerEstudiante(@RequestParam String cta) {
        System.out.println("INFORMACION: " + cta);
        return estudianteServicio.obtenerEstudiante(cta);
    }

    // Alumnos que no han votado
    @GetMapping("/estudiantesSinVoto")
    public ArrayList<EstudianteObjeto> getEstudiantesVoto() {
        return estudianteServicio.faltantesVotar();
    }
}
