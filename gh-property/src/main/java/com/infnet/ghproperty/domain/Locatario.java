package com.infnet.ghproperty.domain;

import com.infnet.ghproperty.dto.PropertyDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "tb_locatario")
public class Locatario extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="locatario_id")
    private Long id;

    private List<PropertyDTO> favoritos;
}
