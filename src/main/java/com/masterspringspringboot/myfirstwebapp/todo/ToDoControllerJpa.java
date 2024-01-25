package com.masterspringspringboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class ToDoControllerJpa {

    private ToDoRepository toDoRepository;


    public ToDoControllerJpa(ToDoService toDoService, ToDoRepository toDoRepository) {
        this.toDoRepository= toDoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllToDos(ModelMap modelMap) {
        String username= getLoggedInUsername(modelMap);
        List<ToDo> toDos = toDoRepository.findByUsername(username);
        modelMap.addAttribute("toDos", toDos);
        return "listToDos";
    }

    private static String getLoggedInUsername(ModelMap modelMap) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "add-todo", method= RequestMethod.GET)
    public String showNewToDoPage(ModelMap modelMap){
        String username= getLoggedInUsername(modelMap);
        ToDo toDo= new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("toDo", toDo);
        return "toDo";
    }
    @RequestMapping(value = "add-todo", method= RequestMethod.POST)
    public String addNewToDoPage(ModelMap modelMap, @Valid ToDo toDo, BindingResult resault){
        if (resault.hasErrors())
            return "toDo";
        String username= getLoggedInUsername(modelMap);
        toDo.setUsername(username);
        toDoRepository.save(toDo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteToDo(@RequestParam int id){
        toDoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateToDoPage(@RequestParam int id, ModelMap modelMap){
        ToDo toDo= toDoRepository.findById(id).get();
        modelMap.addAttribute("toDo", toDo);
        return "toDo";
    }
    @RequestMapping(value="update-todo", method=RequestMethod.POST)
    public String updateToDo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result){
        if(result.hasErrors()) {
            return "toDo";
        }
        String username= getLoggedInUsername(modelMap);
        toDo.setUsername(username);
        toDoRepository.save(toDo);
        return "redirect:list-todos";
    }

}
