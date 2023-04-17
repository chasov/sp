package edu.rd.spcity.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class AbstractCodedEntity extends AbstractEntity {
    @Column(name = "code")
    private String code;
}