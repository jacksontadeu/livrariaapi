package com.jtmjinfo.livrariaapi.service;

import com.jtmjinfo.livrariaapi.model.Autor;
import com.jtmjinfo.livrariaapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor salvarAutor(Autor autor){
        return autorRepository.save(autor);
    }
    public Optional<Autor> listarPorId(Integer id){

        return autorRepository.findById(id);
    }
    public void deletarAutor(Autor autor){
        autorRepository.delete(autor);
    }
    public List<Autor> listarTodos(){
        return autorRepository.findAll();
    }
    public List<Autor> listarComFiltro(String nome,String nacionalidade){
        if(nome != null && nacionalidade != null)
            return autorRepository.findByNomeAndNacionalidade(nome,nacionalidade);
        if (nome != null)
            return autorRepository.findByNome(nome);
        if (nacionalidade != null)
            return autorRepository.findByNacionalidade(nacionalidade);
        return autorRepository.findAll();


    }
}


