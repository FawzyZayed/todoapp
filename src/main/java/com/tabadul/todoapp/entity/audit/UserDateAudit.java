package com.tabadul.todoapp.entity.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdBy","updatedBy"},
        allowGetters = true
)
@Getter
@Setter
@ToString
public abstract class UserDateAudit extends DateAudit {
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private Long createdBy;

    @LastModifiedBy
    @Column(nullable = false)
    private Long updatedBy;

}