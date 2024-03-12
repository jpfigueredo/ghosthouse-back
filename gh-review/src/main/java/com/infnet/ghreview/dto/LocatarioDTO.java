package com.infnet.ghreview.dto;

import lombok.Data;

import java.util.List;

@Data
public class LocatarioDTO {

    private Long id;

    private List<ImovelDTO> favoritos;
}
