package com.proyecto.votacion.Objetos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "admin")

public class AdminObjeto {
    @Id
    @Column(name = "id_admin", nullable = false, unique = true)
    private String id_admin;

    
     @ManyToOne(fetch = FetchType.EAGER)
     
     @JoinColumn(name = "informacion_personal_id_usuario", referencedColumnName =
     "id_usuario", nullable = true)
     private InfoUsuarioObjeto usuarioObjeto;
    
}
