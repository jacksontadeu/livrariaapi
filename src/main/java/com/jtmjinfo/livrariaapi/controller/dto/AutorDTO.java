package com.jtmjinfo.livrariaapi.controller.dto;

import com.jtmjinfo.livrariaapi.model.Autor;

import java.time.LocalDate;

public record AutorDTO(String nome,
                       LocalDate dataNascimento,
                       String nacionalidade,
                       Integer id) {

    public Autor apearAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome());
        autor.setDataNascimento(this.dataNascimento());
        autor.setNacionalidade(this.nacionalidade());
        return autor;

    }
}
