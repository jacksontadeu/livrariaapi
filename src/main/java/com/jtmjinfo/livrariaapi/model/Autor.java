package com.jtmjinfo.livrariaapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autor")
@Data
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"livros"})
public class Autor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;
    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
    @Column(name = "idusuario")
    private Integer idusuario;


    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

}
