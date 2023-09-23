package com.example.springboot.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Luhmeiy",
                        "luhmeiy@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        23));
    }
}
