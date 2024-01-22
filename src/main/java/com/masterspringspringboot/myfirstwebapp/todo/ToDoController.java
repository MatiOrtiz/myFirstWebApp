package com.masterspringspringboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String showNewToDoPage(ModelMap modelMap){
        String username= (String) modelMap.get("name");
        ToDo toDo= new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("toDo", toDo);
        return "toDo";
    }
    @RequestMapping(value = "add-todo", method= RequestMethod.POST)
    public String addNewToDoPage(ModelMap modelMap, @Valid ToDo toDo, BindingResult resault){
        if (resault.hasErrors())
            return "toDo";
        String username= (String) modelMap.get("name");
        toDoService.addToDo(username, toDo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteToDo(@RequestParam int id){
        toDoService.deleteToDo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateToDoPage(@RequestParam int id, ModelMap modelMap){
        ToDo toDo= toDoService.findById(id);
        modelMap.addAttribute("toDo", toDo);
        return "toDo";
    }
    @RequestMapping(value="update-todo", method=RequestMethod.POST)
    public String updateToDo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result){
        if(result.hasErrors()) {
            return "toDo";
        }
        String username= (String) modelMap.get("name");
        toDo.setUsername(username);
        toDoService.updateToDo(toDo);
        return "redirect:list-todos";
    }

}
