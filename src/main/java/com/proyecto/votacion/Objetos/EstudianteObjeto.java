package com.proyecto.votacion.Objetos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "estudiante")
public class EstudianteObjeto {

    @Id
    @Column(name = "cta", nullable = false, unique = true)
    private String cta;

    @Column(name = "carrera", nullable = false, unique = false)
    private String carrera;

    @Column(name = "estatus_voto", nullable = false, unique = false)
    private String estatus_voto;

    
    @ManyToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)//  ---> me sirve para eliminar en la tabla foránea y en la tabla principal
    @JoinColumn(name = "informacion_personal_id_usuario", referencedColumnName = "id_usuario", nullable = true)
    private InfoUsuarioObjeto usuarioObjeto_estudiante;

    @OneToOne(mappedBy = "estudianteRepresentante")
    @JsonIgnore
    private PlanillaObjeto planillaObjeto;

}
