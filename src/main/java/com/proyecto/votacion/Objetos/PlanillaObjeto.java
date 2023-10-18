package com.proyecto.votacion.Objetos;

import jakarta.persistence.FetchType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "planilla")
public class PlanillaObjeto {
    @Id
    @Column(name = "id_planilla", nullable = false, unique = true)
    private String id_planilla;

    @Column(name = "nombre_planilla", nullable = false, unique = true)
    private String nombre_planilla;

    @Column(name = "votos", nullable = true, unique = false)
    private Integer votos;

     @OneToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "estudiante_cta", referencedColumnName = "cta",
    nullable = true)
    private EstudianteObjeto estudianteRepresentante;
    

}
