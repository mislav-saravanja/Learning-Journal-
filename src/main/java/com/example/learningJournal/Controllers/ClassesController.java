package com.example.learningJournal.Controllers;

import com.example.learningJournal.Dto.ClassesDto;
import com.example.learningJournal.Models.Classes;
import com.example.learningJournal.Services.ClassesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import  org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequestMapping("/classes")
@Controller
public class ClassesController {

    private ClassesService classesService;

    @Autowired
    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @GetMapping("")
    public String listClasses(Model model) {
        List<ClassesDto> classes = classesService.findAllClasses();
        model.addAttribute("classes", classes);
        return "classes";
    }

    @GetMapping("/new")
    public String createClassesForm(Model model) {
        Classes classes = new Classes();
        model.addAttribute("classes", classes);
        return "classes-create";
    }

    @GetMapping("/{classesId}")
    public String classesDetail(@PathVariable("classesId") long classesId, Model model) {
        ClassesDto classesDto = classesService.findByClassesId(classesId);
        model.addAttribute("classes", classesDto);
        return "classes-detail";
    }

    @GetMapping("/search")
    public String searchClasses(@RequestParam(value = "query") String query, Model model) {
        List<ClassesDto> classes = classesService.searchClasses(query);
        model.addAttribute("classes", classes);
        return "classes-list";
    }

    @PostMapping("/new")
    public String saveClasses(@ModelAttribute("classes") ClassesDto classesDto) {

        classesService.saveClasses(classesDto);
        return "redirect:/classes";
    }

    @GetMapping("/{classesId}/edit")
    public String editClassesForm(@PathVariable("classesId") long classesId, Model model) {
        ClassesDto classes = classesService.findByClassesId(classesId);
        model.addAttribute("classes", classes);
        return "classes-edit";
    }

    @PostMapping("/{classesId}/edit")
    public String editClassesForm(@PathVariable("classesId") long classesId, @Valid @ModelAttribute("classes") ClassesDto classes, BindingResult result) {
        if (result.hasErrors()) {
            return "classes-edit";
        }

        classes.setId(classesId);
        classesService.updateClasses(classes);
        return "redirect:/classes";
    }

    @PostMapping ("/{classesId}/delete")
    public String deleteClasses(@PathVariable("classesId") long classesId){
        classesService.deleteClasses(classesId);
        return "redirect:/classes";
    }

}


