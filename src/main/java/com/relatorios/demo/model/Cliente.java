package com.relatorios.demo.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Column(name = "endereço")
    private String endereco;
    @Column(name = "observação")
    private String observacao;
    @Column(name = "altitude")
    private Double dAltitude;
    @Column(name = "longitude")
    private Double dLongitude;

    @ManyToOne
    @JoinColumn(name = "uf_id")
    private Uf uf;
}
