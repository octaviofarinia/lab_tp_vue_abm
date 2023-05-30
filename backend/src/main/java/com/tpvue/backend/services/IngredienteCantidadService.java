package com.tpvue.backend.services;

import com.tpvue.backend.repositories.IngredienteCantidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteCantidadService {

    @Autowired
    private IngredienteCantidadRepository ingredienteCantidadRepository;

}
