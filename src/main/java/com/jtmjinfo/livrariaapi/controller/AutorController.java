package com.jtmjinfo.livrariaapi.controller;

import com.jtmjinfo.livrariaapi.controller.dto.AutorDTO;
import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> salvarAutor(@RequestBody AutorDTO autorDto) {
        var autorEntidade = autorDto.mapearAutor();
        autorService.salvarAutor(autorEntidade);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntidade.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> listarPorId(@PathVariable Integer id) {
        Optional<Autor> autorOptional = autorService.listarPorId(id);
        if (autorOptional.isPresent() == false) {
            return ResponseEntity.notFound().build();
        } else {
            Autor autor = autorOptional.get();
            return ResponseEntity.ok(new AutorDTO(autor.getNome(),
                    autor.getDataNascimento(),
                    autor.getNacionalidade(),
                    autor.getId()));
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Integer id){
        Optional<Autor> autorOptional = autorService.listarPorId(id);
        if(autorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        autorService.deletarAutor(autorOptional.get());
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/listartodos")
    public ResponseEntity<List<AutorDTO>> listarTodos(){
        List<AutorDTO> autores = autorService.listarTodos().stream()
                .map(autor -> new AutorDTO(autor.getNome(),
                        autor.getDataNascimento(),
                        autor.getNacionalidade(),
                        autor.getId()))
                .toList();
        return ResponseEntity.ok(autores);
    }
    @GetMapping
    public ResponseEntity<List<AutorDTO>> pesquisar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String nacionalidade
    ){
        List<AutorDTO> autores = autorService.listarComFiltro(nome,nacionalidade).stream()
                .map(autor -> new AutorDTO(autor.getNome(),
                        autor.getDataNascimento(),
                        autor.getNacionalidade(),
                        autor.getId()))
                .toList();
        return ResponseEntity.ok(autores);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> atualizarAutor(@PathVariable Integer id, @RequestBody AutorDTO autorDto){
        Optional<Autor> autorOptional = autorService.listarPorId(id);

        if(autorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var autor = autorOptional.get();
        autor.setNome(autorDto.nome());
        autor.setDataNascimento(autorDto.dataNascimento());
        autor.setNacionalidade(autorDto.nacionalidade());
        autorService.salvarAutor(autor);
        return ResponseEntity.ok(new AutorDTO(autor.getNome(),
                autor.getDataNascimento(),
                autor.getNacionalidade(),
                autor.getId()));


    }
}