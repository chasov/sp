package edu.rd.spcity.dto.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class StreetDto implements Serializable {

    @ApiModelProperty(name = "Номер улица", example = "3456")
    private Long street;

    @ApiModelProperty(name = "Название улицы", example = "АВРОРА УЛ")
    private String name;
}
