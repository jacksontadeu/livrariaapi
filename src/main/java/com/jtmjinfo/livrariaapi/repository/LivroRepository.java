package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.enums.GeneroLivro;
import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro,Integer> {

    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    @Query("select l from Livro as l" )
    List<Livro> listarTodos();

    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutores();

    @Query("select l from Livro l where l.genero = :genero")
    List<Livro> listarLivroPorGenero(@Param("genero") GeneroLivro genero);

    @Modifying
    @Transactional
    @Query("update Livro set isbn= ?1 where id= ?2")
    void alterarIsbn(String isbn,Integer id);

}
