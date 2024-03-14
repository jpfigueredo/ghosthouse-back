package com.infnet.ghproperty.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "tb_proprietario")
public class Proprietario extends Usuario{
}
