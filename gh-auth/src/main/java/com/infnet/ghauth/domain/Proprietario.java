package com.infnet.ghauth.domain;

import com.infnet.ghauth.enums.UserType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@DiscriminatorValue(value = UserType.Values.PROPRIETARIO)
public class Proprietario extends Usuario{
}
