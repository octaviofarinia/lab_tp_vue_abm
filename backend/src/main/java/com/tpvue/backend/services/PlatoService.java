package com.tpvue.backend.services;

import com.tpvue.backend.repositories.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;


}
