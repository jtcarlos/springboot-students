package com.jtcarlos.springbootstudents.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Table
@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", initialValue = 1)
    @GeneratedValue(generator = "student_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private LocalDate birthday;
    private Float grade;

    @Transient
    private String fullName;
    @Transient
    private Integer age;

    public Student() {}
    public Student(Long id, String firstName, String lastName, String emailAddress, LocalDate birthday, Float grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.birthday = birthday;
        this.grade = grade;
    }

    public Long getId() { return this.id; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmailAddress() { return this.emailAddress; }
    public LocalDate getBirthday() { return this.birthday; }
    public Float getGrade() { return this.grade; }
    public String getFullName() { return String.format("%s %s", this.firstName, this.lastName); }
    public Integer getAge() { return Period.between(this.birthday, LocalDate.now()).getYears(); }

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }
    public void setGrade(Float grade) { this.grade = grade;}
}
