package com.infnet.ghpropertysearch.domain;

import com.infnet.ghpropertysearch.dto.ProprietarioDTO;
import com.infnet.ghpropertysearch.enums.TipoCategoria;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tb_propertySearch")
public class PropertySearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="property_id")
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private String descricao;

    private Integer quantidadeQuartos;

    private Integer area;

    private List<Date> datasReservadas;

    @OneToOne
    @JoinColumn(name = "proprietario_id")
    private ProprietarioDTO proprietarioDTO;

    private TipoCategoria categoria;
}
