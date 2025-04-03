package com.dev.school.service.grade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.Grade;
import com.dev.school.repository.grade.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;
    
    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }
    
    @Override
    public void add(Grade grade) {
        gradeRepository.save(grade);
    }
    
    @Override
    public void update(Grade grade) {
        gradeRepository.save(grade);
    }
    
    @Override
    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }
    
    @Override
    public Grade findById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }
} 