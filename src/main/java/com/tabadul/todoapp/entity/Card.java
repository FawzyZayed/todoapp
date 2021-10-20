package com.tabadul.todoapp.entity;

import com.tabadul.todoapp.entity.audit.UserDateAudit;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "card")
public class Card extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String title;

    @NotBlank
    @Size(max = 80)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stack_id", nullable = false)
    private Stack stack;

    @OneToMany(
            mappedBy = "card",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(
            mappedBy = "card",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>();

}
