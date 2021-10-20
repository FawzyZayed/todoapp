package com.tabadul.todoapp.repository;

import com.tabadul.todoapp.entity.Project;
import com.tabadul.todoapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Page<Project> findAllByCreatedByOrEditors(Long createdBy, User editor, Pageable pageable);

    Optional<Project> findByIdAndCreatedByOrEditors(long id, long userId, User editor);
}
