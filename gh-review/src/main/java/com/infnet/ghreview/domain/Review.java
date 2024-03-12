package com.infnet.ghreview.domain;

import com.infnet.ghreview.dto.ImovelDTO;
import com.infnet.ghreview.dto.LocatarioDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="review_id")
    @EqualsAndHashCode.Include
    private Long id;

    private String descricao;

    @OneToOne
    @JoinColumn(name = "imovel_id")
    private ImovelDTO imovel;

    @OneToOne
    @JoinColumn(name = "locatario_id")
    private LocatarioDTO locatario;

}
