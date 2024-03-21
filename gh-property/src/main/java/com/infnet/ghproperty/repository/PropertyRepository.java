package com.infnet.ghproperty.repository;

import com.infnet.ghproperty.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> getPropertyByProprietarioId(Long proprietarioId);
}
