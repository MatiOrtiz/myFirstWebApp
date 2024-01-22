package com.masterspringspringboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
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
        for (int i=1; i<=toDosCount; i++)
            if(i==id)
                toDos.remove(findById(i));
    }

    public ToDo findById(int id){
        ToDo toDoToReturn= null;
        for (ToDo toDo: toDos)
            if(toDo.getId()==id)
                toDoToReturn= toDo;
        return toDoToReturn;
    }

    public void updateToDo(@Valid ToDo toDo){
        deleteToDo(toDo.getId());
        toDos.add(toDo);
    }

}
