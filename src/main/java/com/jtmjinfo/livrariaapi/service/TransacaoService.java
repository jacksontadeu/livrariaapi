package com.jtmjinfo.livrariaapi.service;

import com.jtmjinfo.livrariaapi.enums.GeneroLivro;
import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.model.Livro;
import com.jtmjinfo.livrariaapi.repository.AutorRepository;
import com.jtmjinfo.livrariaapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransacaoService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void executar() {
        Autor autor = new Autor();
        autor.setNome("Jackson Moraes");
        autor.setDataNascimento(LocalDate.of(1976,02,20));
        autor.setNacionalidade("Brasil");

        autorRepository.save(autor);

        Livro livro = new Livro();
        livro.setTitulo("A volta dos que não foram");
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setIsbn("123456789");
        livro.setDataPublicacao(LocalDate.of(2000,05,25));
        livro.setPreco(BigDecimal.valueOf(249.99));
        livro.setAutor(autor);

        livroRepository.save(livro);

    }

}
