package edu.rd.spcity.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class AbstractExternalEntity extends AbstractEntity {
    @Column(name = "external_id", nullable = false, unique = true)
    private Long externalId;

}