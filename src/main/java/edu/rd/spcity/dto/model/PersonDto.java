package edu.rd.spcity.dto.model;

import edu.rd.spcity.model.enums.AddressRegistrationType;
import edu.rd.spcity.model.enums.DocumentType;
import edu.rd.spcity.model.enums.Gender;
import edu.rd.spcity.model.enums.SocialStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PersonDto implements Serializable {

    @ApiModelProperty(name = "Идентификатор пользователя", example = "6301857086800018")
    private Long ein;

    @ApiModelProperty(name = "Серия и номер паспорта", example = "36 99 87584")
    private String documentNumber;

    @ApiModelProperty(name = "тип документа", example = "PASSPORT")
    private DocumentType documentType;

    @ApiModelProperty(name = "Имя", example = "ВЛАДИМИР")
    private String firstName;

    @ApiModelProperty(name = "Фамилия", example = "ГРИДНЕВ")
    private String lastName;

    @ApiModelProperty(name = "Отчество", example = "НИКОЛАЕВИЧ")
    private String middleName;

    @ApiModelProperty(name = "Социальный статус", example = "WORKING")
    private SocialStatus socialStatus;

    @ApiModelProperty(name = "Дата рождения", example = "1957-08-18")
    private LocalDate birthdate;

    @ApiModelProperty(name = "Гендер", example = "MALE")
    private Gender gender;

    @ApiModelProperty(name = "Номер полиса", example = "188798")
    private String policyNumber;

    @ApiModelProperty(name = "Серия полиса", example = "ВМ")
    private String policySeries;

    @ApiModelProperty(name = "Id региона первичный", example = "401")
    private Integer idRegionPrimary;

    @ApiModelProperty(name = "Id региона вторичный", example = "368")
    private Integer idRegionSecondary;

    @ApiModelProperty(name = "Id региона третичный", example = "0")
    private Integer idRegionTertiary;

    @ApiModelProperty(name = "Улица")
    private StreetDto street;

    @ApiModelProperty(name = "Номер дома", example = "194")
    private String buildingNumber;

    @ApiModelProperty(name = "Литера дома", example = "А")
    private String buildingLiter;

    @ApiModelProperty(name = "Номер здания", example = "0")
    private String buildingUnitNumber;

    @ApiModelProperty(name = "Номер квартиры", example = "31")
    private String apartmentNumber;

    @ApiModelProperty(name = "Литера квартиры", example = "В")
    private String apartmentLiter;

    @ApiModelProperty(name = "Тип адреса регистрации", example = "LIVING_IN_CURRENT_ADDRESS")
    private AddressRegistrationType addressRegistrationType;

    @ApiModelProperty(name = "Инн", example = "6311041113")
    private Long inn;

    @ApiModelProperty(name = "Не известно", example = "5218")
    private Integer lpubase;

    @ApiModelProperty(name = "Не известно", example = "17")
    private Integer lpubaseU;

    @ApiModelProperty(name = "Не известно", example = "")
    private String lputer;

    @ApiModelProperty(name = "Не известно", example = "5207")
    private Integer lpudent;

    @ApiModelProperty(name = "Не известно", example = "2")
    private Integer insurer;

    @ApiModelProperty(name = "Не известно", example = "2004-04-13")
    private LocalDate dateIn;

    @ApiModelProperty(name = "Не известно", example = "2004-06-30")
    private LocalDate dateCh;

    @ApiModelProperty(name = "Не известно", example = "4053")
    private Integer agrnum;

    @ApiModelProperty(name = "Пенсия", example = "")
    private String pension;

    @ApiModelProperty(name = "Не известно", example = "1")
    private Integer finYes;

    @ApiModelProperty(name = "Дата создания сущности", example = "2022-03-12 00:37:12.492889")
    private LocalDateTime created;

    @ApiModelProperty(name = "Дата обновления сущности", example = "2022-03-12 00:37:12.492923")
    private LocalDateTime updated;
}
