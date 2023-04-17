package edu.rd.spcity.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class AbstractNamedEntity extends AbstractEntity {
    @Column(name = "name")
    private String name;
}