package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AutorRepositoryTest {
    @Autowired
    private AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("José de Menezes");
        autor.setDataNascimento(LocalDate.of(1978,02,20));
        autor.setNacionalidade("Brasil");

        repository.save(autor);
    }
    @Test
    public void atualizarTest(){
        Autor autor = repository.findById(1).get();
        autor.setNome("José de Menezes da Silva");
        autor.setDataNascimento(LocalDate.of(1950,02,20));
        repository.save(autor);
    }
    @Test
    public void listarTodosTest(){
        repository.findAll().forEach(System.out::println);
    }

}
