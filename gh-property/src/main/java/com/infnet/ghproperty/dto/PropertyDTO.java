package com.infnet.ghproperty.dto;

import com.infnet.ghproperty.enums.TipoCategoria;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class PropertyDTO {

    private Long id;

    @NotNull(message = "O campo de nome do imovel é obrigatorio!")
    private String nome;

    @NotNull(message = "O campo de descricao do imovel é obrigatorio!")
    private String descricao;

    @NotNull(message = "O campo de quantidade de quartos do imovel é obrigatorio!")
    @Min(value = 1, message = "O valor mínimo deve ser 1")
    @Max(value = 10000, message = "O valor máximo deve ser 10000")
    private Integer quantidadeQuartos;

    @NotNull(message = "O campo de area do imovel é obrigatorio!")
    @Min(value = 1, message = "O valor mínimo deve ser 1")
    @Max(value = 10000, message = "O valor máximo deve ser 10000")
    private Integer area;

    private List<LocalDate> datasReservadas;

    @NotNull(message = "O campo de id do proprietario do imovel é obrigatorio!")
    private Long idProprietario;

    @NotNull(message = "O campo de categoria do imovel é obrigatorio!")
    private TipoCategoria categoria;

    @NotNull(message = "O campo de endereco do imovel é obrigatorio!")
    private String endereco;

    @NotNull(message = "O campo de valor da diaria do imovel é obrigatorio!")
    private Double valorDiaria;
}
