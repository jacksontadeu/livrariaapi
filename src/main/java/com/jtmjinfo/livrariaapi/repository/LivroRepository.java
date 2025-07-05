package com.jtmjinfo.livrariaapi.repository;

import com.jtmjinfo.livrariaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Integer> {

}
