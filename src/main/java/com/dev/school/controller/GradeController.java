package com.dev.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.school.model.Grade;
import com.dev.school.service.grade.GradeService;
import com.dev.school.service.student.StudentService;
import com.dev.school.service.subject.SubjectService;

@Controller
@RequestMapping("/grade")
public class GradeController {
    
    @Autowired
    private GradeService gradeService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private SubjectService subjectService;
    
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("grades", gradeService.getAll());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAll());
        return "grade/list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("grade", new Grade());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAll());
        return "grade/add";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute Grade grade) {
        gradeService.add(grade);
        return "redirect:/grade/list";
    }
    
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Grade grade = gradeService.findById(id);
        model.addAttribute("grade", grade);
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAll());
        return "grade/update";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Grade grade) {
        gradeService.update(grade);
        return "redirect:/grade/list";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        gradeService.delete(id);
        return "redirect:/grade/list";
    }
} 