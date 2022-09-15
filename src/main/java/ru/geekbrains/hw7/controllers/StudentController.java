package ru.geekbrains.hw7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.hw7.models.Student;
import ru.geekbrains.hw7.services.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) {
        //student.setId(null);
        return studentService.saveOrUpdate(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) {
        //student.setId(null);
        return studentService.save(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }*/

}
