package com.proyecto.votacion.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.votacion.Objetos.EstudianteObjeto;
import com.proyecto.votacion.Repositorios.EstudianteRepositorio;
import com.proyecto.votacion.Repositorios.PlanillaRepositorio;
// import com.proyecto.votacion.Servicios.PlanillaServicio;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServicio {
    @Autowired
    EstudianteRepositorio estudianteRepositorio;
    PlanillaRepositorio planillaRepositorio;

    EstudianteObjeto estudianteObjeto = new EstudianteObjeto();

    public EstudianteObjeto registrarEstudiante(EstudianteObjeto estudianteData) {
        if (estudianteRepositorio.existsById(estudianteData.getCta())) {
            return estudianteObjeto;
        } else {
            return estudianteRepositorio.save(estudianteData);
        }
    }

    public EstudianteObjeto actualizarEstudiante(EstudianteObjeto estudianteData) {
        if (estudianteRepositorio.existsById(estudianteData.getCta())) {
            return estudianteRepositorio.save(estudianteData);
        } else {
            return estudianteObjeto;
        }
    }

    public List<EstudianteObjeto> obtenerEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    public Optional<EstudianteObjeto> obtenerEstudiante(String cta) {
        return estudianteRepositorio.findById(cta);
    }

    public void eliminarEstudiante(String id) {
        estudianteRepositorio.deleteById(id);
    }

    @Transactional
    public void modificarEstatus_voto(String cta) {
        estudianteRepositorio.actualizarEstatus(cta);
    }

    @Transactional
    public ArrayList<EstudianteObjeto> faltantesVotar() {
        return estudianteRepositorio.faltantesVotar();
    }
}
