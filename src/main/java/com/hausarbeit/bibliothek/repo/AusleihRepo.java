package com.hausarbeit.bibliothek.repo;
import com.hausarbeit.bibliothek.model.Ausleihvorgang;
import com.hausarbeit.bibliothek.model.Publikation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AusleihRepo extends JpaRepository<Ausleihvorgang, Long > {
    Ausleihvorgang findAusleihvorgangByVorgangID(Long ID);

}
