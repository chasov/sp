package edu.rd.spcity.repository;

import edu.rd.spcity.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.Optional;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"))
    Optional<Street> findByStreet(Integer street);
}