package com.jtcarlos.springbootstudents.Services;

import com.jtcarlos.springbootstudents.Exception.APIRequestException;
import com.jtcarlos.springbootstudents.Models.Student;
import com.jtcarlos.springbootstudents.Models.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServices {
    private final StudentRepository studentRepository;

    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public ResponseEntity<Student> getStudent(Long studentId) {
        Optional<Student> studentById = this.studentRepository.findById(studentId);

        if (studentById.isEmpty()) throw new APIRequestException(String.format("Error: Student with ID '%d' does not exists", studentId));

        return ResponseEntity.ok(studentById.get());
    }

    public ResponseEntity<Student> createStudent(Student student) {
        Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmailAddress());
        Optional<Student> studentById = this.studentRepository.findById(student.getId());

        if (studentByEmail.isPresent()) throw new APIRequestException(String.format("Error: Student with email address '%s' already exists", student.getEmailAddress()));
        else if (studentById.isPresent()) throw  new APIRequestException((String.format("Error: Student with ID '%d' already exists", student.getId())));
        else this.studentRepository.save(student);

        return ResponseEntity.ok(student);
    }

    public ResponseEntity<Student> deleteStudent(Long studentId) {
        Optional<Student> studentById = this.studentRepository.findById(studentId);

        if (studentById.isEmpty()) throw new APIRequestException(String.format("Error: Student with ID '%d' does not exists", studentId));
        this.studentRepository.delete(studentById.get());

        return ResponseEntity.ok(studentById.get());
    }

    @Transactional
    public ResponseEntity<Student> updateStudent(Long studentId, Student student) {
        Optional<Student> studentById = this.studentRepository.findById(studentId);
        Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmailAddress());

        if (studentById.isEmpty()) 
            throw new APIRequestException(String.format("Error: Student with ID '%d' does not exists", studentId));
        else if (studentByEmail.isPresent())
            throw new APIRequestException(String.format("Error: Student with email address '%s' already exists", student.getEmailAddress()));
        else {
            Student studentToUpdate = studentById.get();

            studentToUpdate.setFirstName(student.getFirstName() != null ? student.getFirstName() : studentToUpdate.getFirstName());
            studentToUpdate.setLastName(student.getLastName() != null ? student.getLastName() : studentToUpdate.getLastName());
            studentToUpdate.setEmailAddress(student.getEmailAddress() != null ? student.getEmailAddress() : studentToUpdate.getEmailAddress());
            studentToUpdate.setBirthday(student.getBirthday() != null ? student.getBirthday() : studentToUpdate.getBirthday());
            studentToUpdate.setGrade(student.getGrade() != null ? student.getGrade() : studentToUpdate.getGrade());

            return ResponseEntity.ok(studentToUpdate);
        }
    }
}
