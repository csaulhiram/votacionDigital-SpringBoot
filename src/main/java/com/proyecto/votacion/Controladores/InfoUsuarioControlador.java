package com.proyecto.votacion.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.votacion.Objetos.InfoUsuarioObjeto;
import com.proyecto.votacion.Servicios.InfoUsuarioServicio;

@RestController
@RequestMapping("/usuarios")
public class InfoUsuarioControlador {
    @Autowired
    InfoUsuarioServicio infoUsuarioServicio;

    @PostMapping("/registrarUsuario")
    public InfoUsuarioObjeto registrarUsuario(@RequestBody InfoUsuarioObjeto data) {
        return infoUsuarioServicio.registrarUsuario(data);
    }

    @PutMapping("/modificarUsuario")
    public InfoUsuarioObjeto modificarUsuario(@RequestBody InfoUsuarioObjeto data) {
        return infoUsuarioServicio.modificarUsuario(data);
    }

    @GetMapping("/obtenerUsuarios")
    public List<InfoUsuarioObjeto> obtenerUsuarios() {
        return infoUsuarioServicio.obtenerUsuarios();
    }
    

    @DeleteMapping("/eliminarUsuario")
    public void eliminarUsuario(@RequestParam String id) {
        infoUsuarioServicio.deleteUser(id);
    }

    @GetMapping("/obtenerUsuario")
    public Optional<InfoUsuarioObjeto> obtenerUSuario(@RequestParam String id) {
        return infoUsuarioServicio.obtenerUsuario(id);
    }

}
