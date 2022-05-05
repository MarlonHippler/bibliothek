package com.hausarbeit.bibliothek.repo;

import com.hausarbeit.bibliothek.model.Publikation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PublikationsRepository
 * @author Marlon Hippler
 */
@Repository
public interface PublikationRepo extends JpaRepository<Publikation, Long > {
    Publikation findPublikationByPublikationID(Long publikationID);

}
