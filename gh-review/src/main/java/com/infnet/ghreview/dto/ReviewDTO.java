package com.infnet.ghreview.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewDTO {
    @NotNull(message = "O campo de ID do imovel é obrigatório!")
    private Long id;

    @NotNull(message = "O campo de descricao do imovel é obrigatorio!")
    private String descricao;

    private Long idImovel;

    private Long idLocatario;
}
