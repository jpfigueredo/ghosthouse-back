package com.infnet.ghpropertysearch.repository;

import com.infnet.ghpropertysearch.domain.PropertySearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertySearchRepository extends JpaRepository<PropertySearch, Long> {
}
