package edu.rd.spcity.mapper;

import edu.rd.spcity.dto.model.PersonDto;
import edu.rd.spcity.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@Slf4j
public abstract class PersonMapper {

    @Mapping(target = "ein", source = "person.ein")
    @Mapping(target = "documentNumber", source = "documentNumber")
    @Mapping(target = "documentType", source = "documentType")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "socialStatus", source = "socialStatus")
    @Mapping(target = "birthdate", source = "birthdate")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "policyNumber", source = "policyNumber")
    @Mapping(target = "policySeries", source = "policySeries")
    @Mapping(target = "idRegionPrimary", source = "idRegionPrimary")
    @Mapping(target = "idRegionSecondary", source = "idRegionSecondary")
    @Mapping(target = "idRegionTertiary", source = "idRegionTertiary")
    @Mapping(target = "buildingNumber", source = "buildingNumber")
    @Mapping(target = "buildingLiter", source = "buildingLiter")
    @Mapping(target = "buildingUnitNumber", source = "buildingUnitNumber")
    @Mapping(target = "apartmentNumber", source = "apartmentNumber")
    @Mapping(target = "apartmentLiter", source = "apartmentLiter")
    @Mapping(target = "addressRegistrationType", source = "addressRegistrationType")
    @Mapping(target = "street", source = "street")
    @Mapping(target = "created", source = "created")
    @Mapping(target = "updated", source = "updated")
    public abstract PersonDto toDto(Person person);

}
