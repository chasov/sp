package edu.rd.spcity.service.api;

import edu.rd.spcity.dto.model.PersonDto;
import edu.rd.spcity.dto.request.InnRequestDto;
import org.springframework.http.ResponseEntity;

public interface PersonService {

    ResponseEntity<PersonDto> findByInn(InnRequestDto innRequestDto);
}
