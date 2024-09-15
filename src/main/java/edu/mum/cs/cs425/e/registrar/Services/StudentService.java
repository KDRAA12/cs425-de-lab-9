package edu.mum.cs.cs425.e.registrar.Services;


import edu.mum.cs.cs425.e.registrar.models.InternationalStatus;
import edu.mum.cs.cs425.e.registrar.models.Student;
import edu.mum.cs.cs425.e.registrar.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;


    public void seedDb(){
            List<Student> students = new ArrayList<>();

            students.add(new Student(null, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24), InternationalStatus.YES));
            students.add(new Student(null, "000-61-0002", "Bob", null, "Johnson", 3.80, LocalDate.of(2018, 7, 19),InternationalStatus.YES));
            students.add(new Student(null, "000-61-0003", "Charlie", "A.", "Brown", 2.70, LocalDate.of(2020, 9, 10),InternationalStatus.NO));
            students.add(new Student(null, "000-61-0004", "Diana", "Marie", "Evans", 3.90, LocalDate.of(2017, 3, 5),InternationalStatus.YES));
            students.add(new Student(null, "000-61-0005", "Eli", null, "Wilson", 3.60, LocalDate.of(2021, 1, 25),InternationalStatus.NO));
            students.add(new Student(null, "000-61-0006", "Fiona", "Jane", "Adams", 3.75, LocalDate.of(2019, 11, 12),InternationalStatus.NO));
            students.add(new Student(null, "000-61-0007", "George", null, "Lewis", 2.90, LocalDate.of(2020, 6, 18),InternationalStatus.YES));
            students.add(new Student(null, "000-61-0008", "Hannah", "Louise", "Clark", 3.40, LocalDate.of(2018, 12, 30),InternationalStatus.NO));
            students.add(new Student(null, "000-61-0009", "Isaac", null, "Mitchell", 3.25, LocalDate.of(2021, 4, 9),InternationalStatus.YES));
            students.add(new Student(null, "000-61-0010", "Julia", "Anne", "Turner", 3.50, LocalDate.of(2020, 2, 14),InternationalStatus.YES));

            studentRepository.saveAll(students);
            System.out.println("Successfully saved 10 students to the database.");

    }


    public List<Student> findAll(){
            return studentRepository
                    .findAll(Sort.by(Sort.Order.desc("studentId")));
    }

    public Student saveStudent(Student student) {
        student=studentRepository.save(student);
        log.info("saved a new student with id {}",student.getStudentId());
        return student;
    }


    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }


    public Student findById(Long studentId) {
        System.out.println("find By Id "+studentId);
      return   studentRepository.findByStudentId(studentId)
              .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + studentId));
    }

    public Student save(Student updatedStudent) {
        return studentRepository.save(updatedStudent);
    }
}
