package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro,Integer> {

    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    @Query("select l from Livro as l" )
    List<Livro> listarTodos();

    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutores();

}
