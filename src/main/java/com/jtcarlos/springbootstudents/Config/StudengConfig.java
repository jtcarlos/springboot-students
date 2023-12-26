package com.jtcarlos.springbootstudents.Config;

import com.jtcarlos.springbootstudents.Models.Student;
import com.jtcarlos.springbootstudents.Models.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudengConfig {
    @Bean
    CommandLineRunner run(StudentRepository studentRepository) {
        return args -> {
            studentRepository.saveAll(List.of(
                new Student(1L, "John", "Carlos", "john.carlos@gmail.com", LocalDate.of(1999, Month.SEPTEMBER, 13), 98.9F),
                new Student(2L, "Alex", "Doe", "alex.doe@gmail.com", LocalDate.of(2001, Month.APRIL, 19), 82.4F),
                new Student(3L, "David", "Carlisle", "david.carlisle@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 26), 96.5F),
                new Student(4L, "Mary", "Sable", "mary.sable@gmail.com", LocalDate.of(1998, Month.MARCH, 1), 42.1F),
                new Student(5L, "Jenny", "Chan", "jenny.chan@gmail.com", LocalDate.of(1996, Month.JULY, 3), 77.6F)
            ));
        };
    }
}
