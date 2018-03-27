package com.github.scotchg.sample.audit.infra.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@Table(name = "TODO")
public class TodoEntity extends EntityBase{
    @Id
    @Column(name = "ID")
    String id;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "STATUS")
    String status;
}
