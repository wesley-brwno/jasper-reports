package com.relatorios.demo.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "uf_id")
    private Uf uf;
    private Long populacao;
}
