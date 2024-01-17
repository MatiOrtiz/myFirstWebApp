package com.masterspringspringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class ToDoService {
    private static List<ToDo> toDoList;

    static {
        toDoList.add(new ToDo(1, "admin", "Learn Spring Framework", LocalDate.now().plusMonths(2), false));
        toDoList.add(new ToDo(2, "admin", "Learn Spring Boot", LocalDate.now().plusMonths(4), false));
        toDoList.add(new ToDo(3, "admin", "Learn MySql", LocalDate.now().plusMonths(7), false));
    }

    public static List<ToDo> findByUsername(String username) {
        return toDoList;
    }

}
