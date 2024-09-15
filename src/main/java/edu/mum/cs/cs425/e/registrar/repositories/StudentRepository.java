package edu.mum.cs.cs425.e.registrar.repositories;

import edu.mum.cs.cs425.e.registrar.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByStudentId(Long studentId);
}
