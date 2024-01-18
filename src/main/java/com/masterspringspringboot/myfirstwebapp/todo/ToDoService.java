package com.masterspringspringboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> toDos = new ArrayList<ToDo>();

    static {
        toDos.add(new ToDo(1, "admin", "Learn Spring Framework", LocalDate.now().plusMonths(2), false));
        toDos.add(new ToDo(2, "admin", "Learn Spring Boot", LocalDate.now().plusMonths(4), false));
        toDos.add(new ToDo(3, "admin", "Learn MySql", LocalDate.now().plusMonths(7), false));
    }

    public static List<ToDo> findByUsername(String username) {
        return toDos;
    }

}
