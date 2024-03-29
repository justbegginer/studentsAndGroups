package org.student.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.student.site.dao.GroupDao;
import org.student.site.dao.StudentDao;
import org.student.site.dao.TutorDao;
import org.student.site.models.Group;

import javax.validation.Valid;

@Controller
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupDao groupDao;

    @GetMapping
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupDao.getAllGroups());
        return "group/all";
    }

    @GetMapping("/{id}")
    public String getGroupById(@PathVariable("id") int id, Model model,
                               @RequestParam(value = "fullinfo", required = false) boolean fullInfo) {
        if (!fullInfo) {
            model.addAttribute("group", groupDao.getGroupById(id));
            return "group/getGroup";
        }
        else{
            model.addAttribute("completeGroup", groupDao.getCompleteGroupById(id));
            return "group/getGroupWithAllInfo";
        }
    }

    @GetMapping("/new")
    public String newGroup(Model model) {
        model.addAttribute("group", new Group());
        return "group/add";
    }

    @PostMapping()
    public String addNewGroupToDB(@ModelAttribute("group") @Valid Group group,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "group/add";
        }
        groupDao.addGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("{id}/delete")
    public String pageToDelete(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupDao.getGroupById(id));
        return "group/delete";
    }

    @DeleteMapping("{id}")
    public String deleteGroupFromDB(@PathVariable("id") int id) {
        groupDao.deleteGroup(id);
        return "redirect:/groups";
    }

    @GetMapping("{id}/update")
    public String pageToUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupDao.getGroupById(id));
        return "group/update";
    }

    @PatchMapping("{id}")
    public String updateGroup(@ModelAttribute("group") @Valid Group group,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "group/update";
        }
        groupDao.updateGroup(group);
        model.addAttribute("groups", groupDao.getAllGroups());
        return "group/all";
    }
}
