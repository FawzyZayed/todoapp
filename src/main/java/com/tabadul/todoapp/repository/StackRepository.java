package com.tabadul.todoapp.repository;

import com.tabadul.todoapp.entity.Project;
import com.tabadul.todoapp.entity.Stack;
import com.tabadul.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StackRepository extends JpaRepository<Stack,Long> {



}
