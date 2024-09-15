package edu.mum.cs.cs425.e.registrar.controllers;


import edu.mum.cs.cs425.e.registrar.Services.StudentService;
import edu.mum.cs.cs425.e.registrar.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;


    @GetMapping({"/","students"})
    public String student(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);

        return "listStudents";
    }

    @PostMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteById(studentId);
        return "redirect:/";
    }


    @GetMapping("/students/create")
    public String createNewStudent(Model model){
        model.addAttribute("student", new Student());
        return "createStudent";
    }


    @PostMapping("/students/create")
    public String handleCreateStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students/{id}/details")
    public String viewStudentDetails(@PathVariable("id") Long studentId, Model model) {
        Student student = studentService.findById(studentId);
        System.out.println("found a student with id " +studentId);
        model.addAttribute("student", student);
        return "studentDetails";
    }

    @PostMapping("/students/{id}/details")
    public String saveStudentDetails(@PathVariable("id") Long studentId,
                                     @ModelAttribute("student") Student updatedStudent
    ) {
        updatedStudent.setStudentId(studentId);
        System.out.println("saving a student");
        studentService.save(updatedStudent);
        return "redirect:/";
    }



}
