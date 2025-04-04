package com.dev.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.school.model.Subject;
import com.dev.school.service.subject.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    
    @Autowired
    private SubjectService subjectService;
    
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("subjects", subjectService.getAll());
        return "subject/list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("subject", new Subject());
        return "subject/add";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute Subject subject) {
        subjectService.add(subject);
        return "redirect:/subject/list";
    }
    
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Subject subject = subjectService.findById(id);
        model.addAttribute("subject", subject);
        return "subject/update";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Subject subject) {
        subjectService.update(subject);
        return "redirect:/subject/list";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        subjectService.delete(id);
        return "redirect:/subject/list";
    }
}
