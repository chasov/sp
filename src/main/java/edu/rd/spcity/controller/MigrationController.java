package edu.rd.spcity.controller;

import edu.rd.spcity.service.api.MigrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер Миграций
 */
@Slf4j
@RestController
@RequestMapping("spring-city/${url.api.version}/migration")
@Api(tags = "MigrationController")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class MigrationController {


    private final MigrationService migrationService;

    @ApiOperation("Миграция PersonOld в Person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok (Успешный ответ)"),
            @ApiResponse(code = 500, message = "Internal Server Error (Внутренняя ошибка сервера)")
    })
    @GetMapping("/personold")
    public ResponseEntity<?> migratePersonOldToPerson() {
        migrationService.migratePersonOldToPerson();
        return ResponseEntity.ok().build();
    }

}
