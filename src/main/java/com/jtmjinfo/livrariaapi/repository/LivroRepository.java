package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro,Integer> {

    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

}
