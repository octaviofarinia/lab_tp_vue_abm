package com.tpvue.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagenPath;
    private String nombre;
    private double precio;
    private String rubro;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<IngredienteCantidad> ingredientes;

    private String urlImagenPath;

}
