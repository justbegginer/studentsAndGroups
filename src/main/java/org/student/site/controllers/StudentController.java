package org.student.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.student.site.dao.StudentDao;
import org.student.site.models.Group;
import org.student.site.models.Student;

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
    @GetMapping("/new")
    public String newStudent(Model model){
        model.addAttribute("student", new Student());
        return "student/add";
    }
    @PostMapping()
    public String addNewStudentToDB(@ModelAttribute("student") Student student){
        studentDao.addStudent(student);
        return "redirect:/students";
    }
    @GetMapping("{id}/delete")
    public String pageToDelete(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentDao.getStudentById(id));
        return "student/delete";
    }
    @DeleteMapping("{id}")
    public String deleteStudentFromDB(@PathVariable("id") int id){
        studentDao.deleteStudent(id);
        return "redirect:/students";
    }
}
