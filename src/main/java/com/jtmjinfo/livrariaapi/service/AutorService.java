package com.jtmjinfo.livrariaapi.service;

import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor salvarAutor(Autor autor){
        return autorRepository.save(autor);
    }
}
