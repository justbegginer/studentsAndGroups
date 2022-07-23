package org.student.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.student.site.dao.StudentDao;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentDao studentDao;
    @GetMapping
    public String getAllStudents(Model model){
        model.addAttribute("students", studentDao.getAllStudents());
        return "student/all";
    }
    @GetMapping("/{id}")
    public String getStudentById(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentDao.getStudentById(id));
        return "student/getStudent";
    }
}
