package edu.rd.spcity.model.old;

import edu.rd.spcity.model.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_old")
public class PersonOld extends AbstractEntity {

    @Column(name = "ein", nullable = false)
    private Long ein;

    @Column(name = "ndoc")
    private Integer ndoc;

    @Column(name = "nsdoc")
    private Integer nsdoc;

    @Column(name = "sdoc")
    private String sdoc;

    @Column(name = "doctype")
    private Integer doctype;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "secname")
    private String secname;

    @Column(name = "status")
    private Integer status;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "npolis")
    private Integer npolis;

    @Column(name = "spolis")
    private String spolis;

    @Column(name = "rgn1")
    private Integer rgn1;

    @Column(name = "rgn2")
    private Integer rgn2;

    @Column(name = "rgn3")
    private Integer rgn3;

    @Column(name = "street")
    private Integer street;

    @Column(name = "house")
    private Integer house;

    @Column(name = "houseliter")
    private String houseliter;

    @Column(name = "corpus")
    private Integer corpus;

    @Column(name = "flat")
    private Integer flat;

    @Column(name = "flatliter")
    private String flatliter;

    @Column(name = "local")
    private Integer local;

    @Column(name = "lpubase")
    private Integer lpubase;

    @Column(name = "lpubase_u")
    private Integer lpubaseU;

    @Column(name = "lputer")
    private String lputer;

    @Column(name = "lpudent")
    private Integer lpudent;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "insurer")
    private Integer insurer;

    @Column(name = "date_in")
    private String dateIn;

    @Column(name = "date_ch")
    private String dateCh;

    @Column(name = "agrnum")
    private Integer agrnum;

    @Column(name = "pension")
    private String pension;

    @Column(name = "fin_yes")
    private Integer finYes;

}