package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.enums.GeneroLivro;
import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;
    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivroTest(){
        Livro livro = new Livro();
        livro.setIsbn("123456789");
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setDataPublicacao(LocalDate.of(1987,2,26));
        livro.setPreco(BigDecimal.valueOf(129.99));
        livro.setTitulo("Biografia de JTMJ");

        Autor autor = autorRepository.findById(1).get();
        livro.setAutor(autor);

        repository.save(livro);

    }
    @Test
    @Transactional
    void listarLivroIdTest(){
        Livro livro = repository.findById(1).get();
        System.out.println(livro);
    }
    @Test
    void listarLivrosTest(){
        var autor = autorRepository.findById(1).get();
        List<Livro> livros = repository.findByAutor(autor);
        autor.setLivros(livros);
        autor.getLivros().forEach(System.out::println);

    }
    @Test
    void listarLivrosPorTituloTest(){
        List<Livro> livros = repository.findByTitulo("Biografia de JTMJ");
        livros.forEach(System.out::println);
    }
    @Test
    void listarTodosLivrosTest(){
        repository.listarTodos().forEach(System.out::println);
    }
    @Test
    void listarAutoresTest(){
        repository.listarAutores().forEach(System.out::println);
    }
    @Test
    void listarLivroPorGeneroTest(){
        List<Livro> livros = repository.listarLivroPorGenero(GeneroLivro.BIOGRAFIA);
        livros.forEach(System.out::println);
    }


}