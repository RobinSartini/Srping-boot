package com.dev.school.service.grade;

import java.util.List;
import com.dev.school.model.Grade;

public interface GradeService {
    List<Grade> getAll();
    void add(Grade grade);
    void update(Grade grade);
    void delete(Long id);
    Grade findById(Long id);
} 