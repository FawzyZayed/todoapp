package com.tabadul.todoapp.entity;

import com.tabadul.todoapp.entity.audit.UserDateAudit;
import com.tabadul.todoapp.entity.enums.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "task")
public class Task extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String task;

    @NotBlank
    @Size(max = 40)
    @Enumerated
    private Status status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;
}
