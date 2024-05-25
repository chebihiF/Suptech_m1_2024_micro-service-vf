package org.suptech.studentvf;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> fetchAllStudents() {
        return ResponseEntity.ok(studentService.fetchAllStudents());
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> fetchStudent(@PathVariable Long schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }
}
