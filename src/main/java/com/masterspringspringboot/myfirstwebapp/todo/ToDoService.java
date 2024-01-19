package com.masterspringspringboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> toDos = new LinkedList<>();
    private static int toDosCount= 0;

    static {
        toDos.add(new ToDo(++toDosCount, "admin", "Learn Spring Framework", LocalDate.now().plusMonths(2), false));
        toDos.add(new ToDo(++toDosCount, "admin", "Learn Spring Boot", LocalDate.now().plusMonths(4), false));
        toDos.add(new ToDo(++toDosCount, "admin", "Learn MySql", LocalDate.now().plusMonths(7), false));
    }

    public static List<ToDo> findByUsername(String username) {
        return toDos;
    }

    public void addToDo(String username, String description, LocalDate targetDate, boolean done){
        ToDo toDo= new ToDo(++toDosCount, username,description,targetDate,done);
        toDos.add(toDo);
    }

    public void deleteToDo(int id){
        for (ToDo toDo: toDos)
            if(toDo.getId()==id)
                toDos.remove(toDo);
    }

}
