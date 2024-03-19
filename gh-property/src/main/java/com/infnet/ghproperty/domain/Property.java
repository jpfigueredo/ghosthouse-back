package com.infnet.ghproperty.domain;

import com.infnet.ghproperty.dto.ProprietarioDTO;
import com.infnet.ghproperty.enums.TipoCategoria;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tb_property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="property_id")
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private String descricao;

    private Integer quantidadeQuartos;

    private Integer area;

    @ElementCollection
    private List<LocalDate> datasReservadas;

    private Long proprietarioId;

    private TipoCategoria categoria;

    private String endereco;

    private Double valorDiaria;

    private String imageUrl;
}
