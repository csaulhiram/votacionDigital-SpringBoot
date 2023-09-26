package com.proyecto.votacion.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.votacion.Objetos.InfoUsuarioObjeto;
import com.proyecto.votacion.Repositorios.InfoUsuarioRepositorio;

@Service
public class InfoUsuarioServicio {
    @Autowired
    InfoUsuarioRepositorio infoUsuarioRepositorio;
    InfoUsuarioObjeto userInfo = new InfoUsuarioObjeto();

    public InfoUsuarioObjeto registrarUsuario(InfoUsuarioObjeto datos) {
        if (infoUsuarioRepositorio.existsById(datos.getId_usuario())) {
            return datos;
        } else {
            return infoUsuarioRepositorio.save(datos);
        }

    }

    public InfoUsuarioObjeto modificarUsuario(InfoUsuarioObjeto datos) {
        if (infoUsuarioRepositorio.existsById(datos.getId_usuario())) {
            return infoUsuarioRepositorio.save(datos);
        } else {
            return datos;
        }
    }

    public List<InfoUsuarioObjeto> obtenerUsuarios() {
        return infoUsuarioRepositorio.findAll();
    }

    public void eliminarUsuario(String id) {
        infoUsuarioRepositorio.deleteById(id);
    }

    public Optional<InfoUsuarioObjeto> obtenerUsuario(String id) {
        return infoUsuarioRepositorio.findById(id);
    }
}
