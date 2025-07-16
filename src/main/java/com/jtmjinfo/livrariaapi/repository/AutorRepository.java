package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository <Autor,Integer>{
    List<Autor> findByNome(String nome);
    List<Autor> findByNacionalidade(String nacionalidade);
    List<Autor> findByNomeAndNacionalidade(String nome,String nacionalidade);
}
