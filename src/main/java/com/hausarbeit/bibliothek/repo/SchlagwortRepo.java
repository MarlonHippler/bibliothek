package com.hausarbeit.bibliothek.repo;


import com.hausarbeit.bibliothek.model.Schlagwoerter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Schlagwort Repository
 * @author Marlon Hippler
 */
@Repository
public interface SchlagwortRepo extends JpaRepository<Schlagwoerter, Long > {

    Schlagwoerter findSchlagwoerterBySchlagwoerterID(Long schlagwoerterID);

    @Query(value ="SELECT schlagwoerterid from schlagwoerter a where a.schlagwort=:schlagwort",nativeQuery = true)
    Long findBySchlagwort(@Param("schlagwort") String schlagwort);

}
