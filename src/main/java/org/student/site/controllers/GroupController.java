package org.student.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.student.site.dao.GroupDao;

@Controller
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupDao groupDao;
    @GetMapping
    public String getAllGroups(Model model){
        model.addAttribute("groups", groupDao.getAllGroups());
        return "group/all";
    }
    @GetMapping("/{id}")
    public String getGroupById(@PathVariable("id") int id, Model model){
        model.addAttribute("group", groupDao.getGroupById(id));
        return "group/getGroup";
    }
}
