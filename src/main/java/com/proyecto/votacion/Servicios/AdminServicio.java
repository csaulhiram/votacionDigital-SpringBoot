package com.proyecto.votacion.Servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.votacion.Objetos.AdminObjeto;
import com.proyecto.votacion.Repositorios.AdminRepositorio;

@Service
public class AdminServicio {
    @Autowired
    AdminRepositorio adminRepositorio;

    AdminObjeto adminObjeto = new AdminObjeto();

    public AdminObjeto registrarAdmin(AdminObjeto adminData){
        if( adminRepositorio.existsById(adminData.getId_admin())) {
            return adminObjeto;
        } else {
            return adminRepositorio.save(adminData);
        }
    }

    public List<AdminObjeto> obtenerAdmins() {
        return adminRepositorio.findAll();
    }

    public void eliminarAdmin(String id) {
        adminRepositorio.deleteById(id);
    }
}
