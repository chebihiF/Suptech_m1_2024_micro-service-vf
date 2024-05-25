package org.suptech.schoolvf;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/school")
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

   @GetMapping
    public ResponseEntity<List<School>> fetchAllSchools() {
        return ResponseEntity.ok(schoolService.fetchAllSchools());
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> fetchSchoolWithStudents(@PathVariable Long schoolId) {
        return ResponseEntity.ok(schoolService.fetchSchoolWithStudents(schoolId));
    }

}
