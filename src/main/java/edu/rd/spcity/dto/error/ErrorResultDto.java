package edu.rd.spcity.dto.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResultDto {

    private String id;

    private LocalDateTime timestamp;

    private int status;

    private String message;

    private String debugInfo;
}
