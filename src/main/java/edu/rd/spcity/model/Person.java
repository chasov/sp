package edu.rd.spcity.model;

import edu.rd.spcity.model.common.AbstractEntity;
import edu.rd.spcity.model.enums.AddressRegistrationType;
import edu.rd.spcity.model.enums.DocumentType;
import edu.rd.spcity.model.enums.Gender;
import edu.rd.spcity.model.enums.SocialStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person extends AbstractEntity {

    @Column(name = "ein", nullable = false)
    private Long ein;

    @Column(name = "document_number")
    private String documentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_status")
    private SocialStatus socialStatus;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "policy_series")
    private String policySeries;

    @Column(name = "id_region_primary")
    private Integer idRegionPrimary;

    @Column(name = "id_region_secondary")
    private Integer idRegionSecondary;

    @Column(name = "id_region_tertiary")
    private Integer idRegionTertiary;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "street_id")
    private Street street;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "building_liter")
    private String buildingLiter;

    @Column(name = "building_unit_number")
    private String buildingUnitNumber;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "apartment_liter")
    private String apartmentLiter;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_registration_type")
    private AddressRegistrationType addressRegistrationType;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "lpubase")
    private Integer lpubase;

    @Column(name = "lpubase_u")
    private Integer lpubaseU;

    @Column(name = "lputer")
    private String lputer;

    @Column(name = "lpudent")
    private Integer lpudent;

    @Column(name = "insurer")
    private Integer insurer;

    @Column(name = "date_in")
    private LocalDate dateIn;

    @Column(name = "date_ch")
    private LocalDate dateCh;

    @Column(name = "agrnum")
    private Integer agrnum;

    @Column(name = "pension")
    private String pension;

    @Column(name = "fin_yes")
    private Integer finYes;

    @CreationTimestamp
    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;

}