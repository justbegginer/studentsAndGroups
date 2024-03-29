package org.student.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.student.site.dao.TutorDao;
import org.student.site.models.Tutor;

import javax.validation.Valid;
import java.net.BindException;

@Controller
@RequestMapping("/tutors")
public class TutorController {
    @Autowired
    public TutorDao tutorDao;

    @GetMapping
    public String getAllTutors(Model model) {
        model.addAttribute("tutors", tutorDao.getAllTutors());
        return "/tutor/all";
    }

    @GetMapping("/{id}")
    public String getTutorById(@PathVariable("id") int id, Model model) {
        model.addAttribute("tutor", tutorDao.getTutorById(id));
        return "tutor/getTutor";
    }

    @GetMapping("/new")
    public String newTutor(Model model) {
        model.addAttribute("tutor", new Tutor());
        return "tutor/add";
    }

    @PostMapping()
    public String addNewTutorToDB(@ModelAttribute("tutor") @Valid Tutor tutor,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "tutor/add";
        }
        tutorDao.addTutor(tutor);
        return "redirect:/tutors";
    }

    @GetMapping("{id}/delete")
    public String pageToDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("tutor", tutorDao.getTutorById(id));
        return "tutor/delete";
    }

    @DeleteMapping("{id}")
    public String deleteTutorFromDB(@PathVariable("id") int id) {
        tutorDao.deleteTutor(id);
        return "redirect:/tutors";
    }

    @GetMapping("{id}/update")
    public String pageToUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("tutor", tutorDao.getTutorById(id));
        return "tutor/update";
    }

    @PatchMapping("{id}")
    public String updateGroup(@ModelAttribute("tutor") @Valid Tutor tutor,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "tutor/update";
        }
        tutorDao.updateTutor(tutor);
        model.addAttribute("tutors", tutorDao.getAllTutors());
        return "tutor/all";
    }
}
