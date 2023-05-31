package com.tpvue.backend.controllers;

import com.tpvue.backend.entities.Instrumento;
import com.tpvue.backend.services.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrumentos")
public class InstrumentoController {

    @Autowired
    private InstrumentoService instrumentoService;

    @GetMapping("")
    public ResponseEntity<?> listarTodos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

    @PostMapping("/save-list")
    public ResponseEntity<?> saveList(@RequestBody List<Instrumento> instrumentos) {
        try {
            instrumentoService.saveList(instrumentos);
            return ResponseEntity.status(HttpStatus.CREATED).body("");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

    @GetMapping("/obtener-imagen/{imageName}")
    public ResponseEntity<?> obtenerImagen(@PathVariable String imageName) {
        try {
            Resource image = instrumentoService.loadImage(imageName);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + image.getFilename() + "\"")
                    .body(image);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
