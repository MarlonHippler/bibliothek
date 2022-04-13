package com.hausarbeit.bibliothek.repo;

import com.hausarbeit.bibliothek.model.Publikation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PublikationRepo extends JpaRepository<Publikation, Long > {
    Optional<Publikation> findPublikationsByTitel(String Titel);
}
