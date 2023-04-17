package edu.rd.spcity.repository;

import edu.rd.spcity.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT person FROM Person person JOIN FETCH person.street")
    List<Person> findAll();

    Optional<Person> findByInn(Long inn);
}