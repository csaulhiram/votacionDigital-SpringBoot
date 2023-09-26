package com.proyecto.votacion.Objetos;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "informacion_personal")
public class InfoUsuarioObjeto {
    @Id
    @Column(name = "id_usuario", unique = true, nullable = false)
    private String id_usuario;

    @Column(name = "nombres", unique = false, nullable = false)
    private String nombres;

    @Column(name = "apellidos", unique = false, nullable = false)
    private String apellidos;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "perfil", unique = true, nullable = false)
    private String perfil;

    @OneToMany(mappedBy = "usuarioObjeto")
    @JsonIgnore
    private Set<AdminObjeto> adminObjeto;

    @OneToMany(mappedBy = "usuarioObjeto_estudiante")
    @JsonIgnore
    private Set<EstudianteObjeto> estudianteObjeto;


}