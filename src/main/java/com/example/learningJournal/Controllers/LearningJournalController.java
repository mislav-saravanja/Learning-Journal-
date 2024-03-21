package com.example.learningJournal.Controllers;


import com.example.learningJournal.Dto.LearningJournalDto;
import com.example.learningJournal.Models.LearningJournal;
import com.example.learningJournal.Services.LearningJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LearningJournalController {
    private LearningJournalService learningJournalService;
    @Autowired
    public LearningJournalController(LearningJournalService learningJournalService) {
        this.learningJournalService = learningJournalService;
    }
    // List all Journals
    @GetMapping("/journal")
    private String listLearningJournals (Model model){
        List<LearningJournalDto> learningJournalDtos = learningJournalService.findAllLearningJournals();
        model.addAttribute("learningJournalDtos", learningJournalDtos);
        return "journal-list";
    }

    // Create new Journal

    @GetMapping ("/journal/new")
    private String CrateNewJournalGet (Model model){
        LearningJournal learningJournal = new LearningJournal();
        model.addAttribute("learningJournal", learningJournal);
        return "journal-create";
    }

    @PostMapping("/journal/new")
    private String CreateNewJournalPost (@ModelAttribute ("learningJournal") LearningJournalDto learningJournalDto){
        learningJournalService.saveJournal(learningJournalDto);
        return "redirect:/journal";
    }

    // Delete
    @PostMapping("/journal/{learningJournalId}/delete")
    private String DeleteJournal(@PathVariable ("learningJournalId") long learningJournalId){
        learningJournalService.deleteJournal(learningJournalId);
        return "redirect:/journal";

    }

    //Edit user
    @GetMapping("/journal/{learningJournalId}/edit")
    private String EditUserGet (@PathVariable("learningJournalId") long learningJournalId, Model model) {
        LearningJournalDto learningJournalDto = learningJournalService.findByJournalId(learningJournalId);
        model.addAttribute("learningJournalDto", learningJournalDto);
        return "journal-edit";
    }

    @PostMapping("/journal/{learningJournalId}/edit")
    private String EditUserPost (@PathVariable ("learningJournalId") long learningJournalId, @ModelAttribute ("learningJournalDto") LearningJournalDto learningJournalDto){
        learningJournalDto.setId(learningJournalId);
        learningJournalService.saveJournal(learningJournalDto);
        return "redirect:/journal";
    }


}
