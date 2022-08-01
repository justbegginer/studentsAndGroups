package org.student.site.controllers;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.student.site.dao.GroupDao;
import org.student.site.dao.StudentDao;
import org.student.site.dao.TutorDao;

@Controller
public class MainController {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TutorDao tutorDao;
    @GetMapping("/search")
    public String search(Model model, @RequestParam("word") String word){
        try{
            int id = Integer.parseInt(word);
            model.addAttribute("groups", groupDao.getGroupById(id));
            model.addAttribute("students", studentDao.getStudentById(id));
            model.addAttribute("tutors", tutorDao.getTutorById(id));
            model.addAttribute("word", id);
        }
        catch (NumberFormatException exception){
            model.addAttribute("students", studentDao.searchByString(word));
            model.addAttribute("tutors", tutorDao.searchByString(word));
            model.addAttribute("word", word);
        }
        return "search";
    }

}
