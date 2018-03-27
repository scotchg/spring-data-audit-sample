package com.github.scotchg.sample.audit.infra.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntityBase {
    @CreatedBy @Column(name = "CREATOR")
    String creator;
    @CreatedDate @Column(name = "CREATED_AT")
    Date createdAt;
    @LastModifiedBy @Column(name = "MODIFIER")
    String modifier;
    @LastModifiedDate @Column(name = "MODIFIED_AT")
    Date modifiedAt;
}
