package edu.rd.spcity.mapper;

import edu.rd.spcity.model.Person;
import edu.rd.spcity.model.Street;
import edu.rd.spcity.model.enums.AddressRegistrationType;
import edu.rd.spcity.model.enums.DocumentType;
import edu.rd.spcity.model.enums.Gender;
import edu.rd.spcity.model.enums.SocialStatus;
import edu.rd.spcity.model.old.PersonOld;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static edu.rd.spcity.util.DataFormatUtil.PERSON_OLD_DATE_FORMAT;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@Slf4j
public abstract class PersonOldMapper {

    @Mapping(target = "ein", source = "personOld.ein")
    @Mapping(target = "documentNumber", expression = "java(parseDocumentNumber(personOld))")
    @Mapping(target = "documentType", expression = "java(convertDocumentType(personOld.getDoctype()))")
    @Mapping(target = "firstName", source = "personOld.name")
    @Mapping(target = "lastName", source = "personOld.surname")
    @Mapping(target = "middleName", source = "personOld.secname")
    @Mapping(target = "socialStatus", expression = "java(convertToSocialStatus(personOld.getStatus()))")
    @Mapping(target = "birthdate", expression = "java(parseDate(personOld.getBirthday()))")
    @Mapping(target = "gender", expression = "java(convertToGender(personOld.getSex()))")
    @Mapping(target = "policyNumber", source = "personOld.npolis")
    @Mapping(target = "policySeries", source = "personOld.spolis")
    @Mapping(target = "idRegionPrimary", source = "personOld.rgn1")
    @Mapping(target = "idRegionSecondary", source = "personOld.rgn2")
    @Mapping(target = "idRegionTertiary", source = "personOld.rgn3")
    @Mapping(target = "buildingNumber", source = "personOld.house")
    @Mapping(target = "buildingLiter", source = "personOld.houseliter")
    @Mapping(target = "buildingUnitNumber", source = "personOld.corpus")
    @Mapping(target = "apartmentNumber", source = "personOld.flat")
    @Mapping(target = "apartmentLiter", source = "personOld.flatliter")
    @Mapping(target = "addressRegistrationType", expression = "java(convertToAddressRegistrationType(personOld.getLocal()))")
    @Mapping(target = "street", source = "street")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    public abstract Person toPerson(PersonOld personOld, Street street);

    protected String parseDocumentNumber(PersonOld personOld) {
        String numberSeriesDocument = String.format("%02d", personOld.getNsdoc());
        String numberDocument = personOld.getNdoc().toString();

        String seriesDocument;
        if (StringUtils.isNumeric(personOld.getSdoc())) {
            seriesDocument = String.format("%02d", Integer.parseInt(personOld.getSdoc()));
        } else {
            seriesDocument = personOld.getSdoc();
        }

        return numberSeriesDocument + ' ' + seriesDocument + ' ' + numberDocument;
    }

    protected DocumentType convertDocumentType(Integer docType) {
        switch (docType) {
            case 1:
                return DocumentType.PASSPORT;
            case 2:
                return DocumentType.BIRTH_CERTIFICATE;
            case 3:
                return DocumentType.MVD_PASSPORT;
            case 4:
                return DocumentType.FOREIGN_PASSPORT;
            default:
                return null;
        }
    }

    protected SocialStatus convertToSocialStatus(Integer status) {
        switch (status) {
            case 1:
                return SocialStatus.WORKING;
            case 2:
                return SocialStatus.PRESCHOOLER;
            case 3:
                return SocialStatus.STUDENT;
            case 4:
                return SocialStatus.UNEMPLOYED;
            case 5:
                return SocialStatus.REFUGEE;
            case 6:
                return SocialStatus.TEMPORARILY_INACTIVE;
            case 7:
                return SocialStatus.RETIRED_PEOPLE;
            default:
                return null;
        }
    }

    protected Gender convertToGender(Integer sex) {
        switch (sex) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return null;
        }
    }

    protected AddressRegistrationType convertToAddressRegistrationType(Integer local) {
        switch (local) {
            case 1:
                return AddressRegistrationType.LIVING_IN_CURRENT_ADDRESS;
            case 2:
                return AddressRegistrationType.LIVING_IN_OTHER_ADDRESS;
            case 3:
                return AddressRegistrationType.INDIVIDUAL_ENTREPRENEUR;
            default:
                return null;
        }
    }

    protected LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(PERSON_OLD_DATE_FORMAT));
        } catch (Exception e) {
            log.error("Could not parse date = {}", date, e);
            return null;
        }
    }
}
