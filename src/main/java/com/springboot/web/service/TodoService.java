package com.springboot.web.service;

import java.util.*;

import com.springboot.web.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.model.Todo;

@Service
public class TodoService {
    //private static List<Todo> todos = new ArrayList<Todo>();

    @Autowired
    TodoDao todoDao;

//    static {
//        todos.add(new Todo(1, "amarjeet", "Learn Spring MVC", new Date(),
//                false, "test1@gmail.com", "12345", "LA"));
//        todos.add(new Todo(2, "amarjeet", "Learn Struts", new Date(), false, "test2@gmail.com", "123456", "LA"));
//        todos.add(new Todo(3, "amarjeet", "Learn Hibernate", new Date(),
//                false, "test3@gmail.com", "1234567", "LA"));
//
//
//    }

    public List<Todo> retrieveTodos(String user) {
        return (List<Todo>) todoDao.findAll();
    }
    
    public Todo retrieveTodo(int id) {
        return todoDao.findOne(id);
    }

    public void updateTodo(Todo todo){
    		Optional<Todo> t = Optional.ofNullable(todoDao.findOne(todo.getId()));
    		if (t.isPresent()){
    		    todoDao.delete(t.get());
    		    todoDao.save(t.get());
            }
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone, String email, String password, String city) {
            todoDao.save(new Todo(name,desc,targetDate,isDone,email,password,city));

    }

    public void deleteTodo(int id) {
        todoDao.delete(id);
    }
}