package com.dev.school.repository.grade;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dev.school.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
} 