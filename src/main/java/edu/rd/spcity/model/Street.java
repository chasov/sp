package edu.rd.spcity.model;

import edu.rd.spcity.model.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "street")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Street extends AbstractEntity {

    @Column(name = "street", nullable = false)
    private Integer street;

    @Column(name = "name")
    private String name;

}