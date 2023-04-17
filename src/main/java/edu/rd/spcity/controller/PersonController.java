package edu.rd.spcity.controller;

import edu.rd.spcity.dto.model.PersonDto;
import edu.rd.spcity.dto.request.InnRequestDto;
import edu.rd.spcity.service.api.PersonService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Контроллер Человека
 */
@Slf4j
@Validated
@RestController
@RequestMapping("spring-city/${url.api.version}/person")
@Api(tags = "PersonController")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PersonController {

    private final PersonService personService;

    @ApiOperation("Получение пользователя по ИНН")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok (Успешный ответ)"),
            @ApiResponse(code = 400, message = "Bad request (Ошибочные данные пользователя)"),
            @ApiResponse(code = 500, message = "Internal Server Error (Внутренняя ошибка сервера)")
    })
    @PostMapping("findbyinn")
    public ResponseEntity<PersonDto> findPersonByInn(
            @ApiParam(value = "ИНН", required = true) @RequestBody @Valid InnRequestDto innRequestDto) {

        return personService.findByInn(innRequestDto);
    }


}
