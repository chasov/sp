package edu.rd.spcity.service;

import edu.rd.spcity.dto.model.PersonDto;
import edu.rd.spcity.dto.request.InnRequestDto;
import edu.rd.spcity.mapper.PersonMapper;
import edu.rd.spcity.repository.PersonRepository;
import edu.rd.spcity.service.api.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor(force = true)

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public ResponseEntity<PersonDto> findByInn(InnRequestDto innRequestDto) {
        return personRepository.findByInn(innRequestDto.getInn())
                .map(personMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
