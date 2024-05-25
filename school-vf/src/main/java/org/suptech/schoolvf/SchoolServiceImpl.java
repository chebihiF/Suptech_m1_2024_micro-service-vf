package org.suptech.schoolvf;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService{

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<School> fetchAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse fetchSchoolWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                        .schoolName("NOT_FOUND")
                        .schoolEmail("NOT_FOUND")
                        .build()
        );
        var students = studentClient.fundAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .schoolName(school.getSchoolName())
                .schoolEmail(school.getSchoolEmail())
                .students(students)
                .build();
    }
}
