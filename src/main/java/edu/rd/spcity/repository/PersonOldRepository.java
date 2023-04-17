package edu.rd.spcity.repository;

import edu.rd.spcity.model.old.PersonOld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonOldRepository extends JpaRepository<PersonOld, Long> {

}