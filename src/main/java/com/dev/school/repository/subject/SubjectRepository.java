package com.dev.school.repository.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.school.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
