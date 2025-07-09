package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacoesTest {
    @Autowired
    AutorRepository autorRepository;

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    LivroRepository livroRepository;

    @Test
    void executarTest(){
        transacaoService.executar();
    }

}
