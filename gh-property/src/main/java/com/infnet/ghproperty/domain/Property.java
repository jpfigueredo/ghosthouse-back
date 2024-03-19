package com.infnet.ghproperty.domain;

import com.infnet.ghproperty.dto.ProprietarioDTO;
import com.infnet.ghproperty.enums.TipoCategoria;
import jakarta.persistence.*;
import lombok.*;
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

    private List<Date> datasReservadas;

    @OneToOne
    @JoinColumn(name = "proprietario_id")
    private ProprietarioDTO proprietarioDTO;

    private TipoCategoria categoria;
}
