package com.infnet.ghauth.repository;

import com.infnet.ghauth.domain.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
    Optional<Locatario> findByEmail(String email);
}
