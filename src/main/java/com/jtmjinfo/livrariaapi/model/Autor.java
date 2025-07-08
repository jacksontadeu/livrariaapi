package com.jtmjinfo.livrariaapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autor")
@Data
@ToString(exclude = {"livros"})
public class Autor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false,length = 100)
    private String nome;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "nacionalidade", nullable = false,length = 50)
    private String nacionalidade;

   @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

}
