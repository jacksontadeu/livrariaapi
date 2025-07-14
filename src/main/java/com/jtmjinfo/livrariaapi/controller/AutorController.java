package com.jtmjinfo.livrariaapi.controller;

import com.jtmjinfo.livrariaapi.controller.dto.AutorDTO;
import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> salvarAutor(@RequestBody AutorDTO autorDto) {
        var autorEntidade = autorDto.apearAutor();
        autorService.salvarAutor(autorEntidade);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntidade.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}