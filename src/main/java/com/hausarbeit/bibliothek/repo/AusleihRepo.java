package com.hausarbeit.bibliothek.repo;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AusleihvorgangsRepository
 * @author Marlon Hippler
 */

@Repository

public interface AusleihRepo extends JpaRepository<Ausleihvorgang, Long > {
    Ausleihvorgang findAusleihvorgangByVorgangID(Long ID);

    @Query(value ="SELECT * from ausleihvorgang a where a.pubID=:pubID",nativeQuery = true)
    List<Ausleihvorgang> findByPublikationID(@Param("pubID") Long pubID);

}
