package com.masterspringspringboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
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

    @RequestMapping(value = "add-todo", method= RequestMethod.GET)
    public String showNewToDoPage(){
        return "toDo";
    }
    @RequestMapping(value = "add-todo", method= RequestMethod.POST)
    public String addNewToDoPage(@RequestParam String description, ModelMap modelMap){
        toDoService.addToDo((String) modelMap.get("name"),description, LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }


}
