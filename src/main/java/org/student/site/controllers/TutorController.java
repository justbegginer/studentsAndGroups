package org.student.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.student.site.dao.TutorDao;

@Controller
@RequestMapping("/tutors")
public class TutorController {
    @Autowired
    public TutorDao tutorDao;
    @GetMapping
    public String getAllTutors(Model model){
        model.addAttribute("tutors", tutorDao.getAllTutors());
        return "/tutor/all";
    }
    @GetMapping("/{id}")
    public String getTutorById(@PathVariable("id") int id, Model model){
        model.addAttribute("tutor", tutorDao.getTutorById(id));
        return "tutor/getTutor";
    }
}
