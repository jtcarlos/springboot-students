package com.jtcarlos.springbootstudents.Controllers;

import com.jtcarlos.springbootstudents.Models.Student;
import com.jtcarlos.springbootstudents.Services.StudentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    private final StudentServices studentServices;

    public StudentRestController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentServices.getAllStudents();
    }

    @GetMapping(path = "{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return this.studentServices.getStudent(studentId);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return this.studentServices.createStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId) {
        return this.studentServices.deleteStudent(studentId);
    }

    @PatchMapping(path = "{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        return this.studentServices.updateStudent(studentId, student);
    }
}
