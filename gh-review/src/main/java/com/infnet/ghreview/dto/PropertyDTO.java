package com.infnet.ghreview.dto;

import com.infnet.ghreview.enums.TipoCategoria;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PropertyDTO {

    @NotNull(message = "O campo de ID do imovel é obrigatório!")
    private Long id;

    @NotNull(message = "O campo de nome do imovel é obrigatorio!")
    private String nome;

    @NotNull(message = "O campo de descricao do imovel é obrigatorio!")
    private String descricao;

    @NotNull(message = "O campo de quantidade de quartos do imovel é obrigatorio!")
    @Min(value = 1, message = "O valor mínimo deve ser 1")
    @Max(value = 10000, message = "O valor máximo deve ser 10000")
    private Integer quantidadeQuartos;

    @NotNull(message = "O campo de descricao do imovel é obrigatorio!")
    @Min(value = 1, message = "O valor mínimo deve ser 1")
    @Max(value = 10000, message = "O valor máximo deve ser 10000")
    private Integer area;

    @NotNull(message = "O campo de descricao do imovel é obrigatorio!")
    private List<Date> datasReservadas;

    private Long idProprietario;

    private TipoCategoria categoria;
}
