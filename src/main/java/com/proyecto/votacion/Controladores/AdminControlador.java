package com.proyecto.votacion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.votacion.Objetos.AdminObjeto;
import com.proyecto.votacion.Servicios.AdminServicio;
import com.proyecto.votacion.Servicios.InfoUsuarioServicio;

@RestController
@RequestMapping("/admin")
public class AdminControlador {
    
    @Autowired
    AdminServicio adminServicio;
    InfoUsuarioServicio infoUsuarioServicio;

    @PostMapping(path = "/registrarAdmin", consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public AdminObjeto registrarAdmin (AdminObjeto adminObjeto) {
        return adminServicio.registrarAdmin(adminObjeto);
    } 

    @GetMapping("/obtenerAdmins")
    public List<AdminObjeto> obtenerAdmin() {
        return adminServicio.obtenerAdmins();
    }

    @DeleteMapping("/eliminarAdmin")
    public void eliminarAdmin(String id) {
        adminServicio.eliminarAdmin(id);
    }
}
