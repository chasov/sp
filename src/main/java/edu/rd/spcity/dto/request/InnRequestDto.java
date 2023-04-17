package edu.rd.spcity.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class InnRequestDto implements Serializable {

    @ApiModelProperty(value = "Индивидуальный Идентификационный Номер", example = "6314006195", required = true)
    @NotNull
    private Long inn;
}
