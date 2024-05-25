package org.suptech.studentvf;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> fetchAllStudents();
    List<Student> findAllStudentsBySchool(Long schoolId);
}
