package com.ids.todont.repository;

import com.ids.todont.entity.Priority;
import com.ids.todont.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
}