package com.tpvue.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instrumento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instrumento;
    private String marca;
    private String modelo;
    private String imagen;
    private String precio;
    private String costoEnvio;
    private String cantidadVendida;

    @Column(length = 1000)
    private String descripcion;

}
