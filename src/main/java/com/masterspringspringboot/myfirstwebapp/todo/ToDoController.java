package com.masterspringspringboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String listAllToDos(ModelMap modelMap) {
        List<ToDo> toDos = ToDoService.findByUsername("admin");
        modelMap.addAttribute("toDos", toDos);
        return "listToDos";
    }

}
