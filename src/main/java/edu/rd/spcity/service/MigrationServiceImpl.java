package edu.rd.spcity.service;

import edu.rd.spcity.exception.MigrationEntityException;
import edu.rd.spcity.mapper.PersonOldMapper;
import edu.rd.spcity.model.Person;
import edu.rd.spcity.model.Street;
import edu.rd.spcity.model.old.PersonOld;
import edu.rd.spcity.repository.PersonOldRepository;
import edu.rd.spcity.repository.PersonRepository;
import edu.rd.spcity.repository.StreetRepository;
import edu.rd.spcity.service.api.MigrationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MigrationServiceImpl implements MigrationService {

    private final PersonOldRepository personOldRepository;

    private final PersonRepository personRepository;

    private final StreetRepository streetRepository;

    private final PersonOldMapper personOldMapper;

    @Override
    public void migratePersonOldToPerson() {
        log.debug("Started migration from table 'person_old' to 'person'...");
        List<Person> persons = personRepository.findAll();

        if (!persons.isEmpty()) {
            throw new MigrationEntityException("Table 'person' is Not empty!");
        }

        List<PersonOld> personOlds = personOldRepository.findAll();

        if (personOlds.isEmpty()) {
            throw new MigrationEntityException("Table 'person_old' is Empty!");
        }

        personOlds.forEach(personOld -> {
            Street street = streetRepository.findByStreet(personOld.getStreet()).orElse(null);
            Person person = personOldMapper.toPerson(personOld, street);

            personRepository.save(person);
        });

        log.debug("Ending migration from table 'person_old' to 'person'.");
    }
}
