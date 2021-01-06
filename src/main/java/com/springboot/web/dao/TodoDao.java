package com.springboot.web.dao;

import com.springboot.web.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends CrudRepository<Todo, Integer> {
}
