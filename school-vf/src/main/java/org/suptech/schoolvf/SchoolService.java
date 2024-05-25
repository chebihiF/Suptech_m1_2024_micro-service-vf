package org.suptech.schoolvf;

import java.util.List;

public interface SchoolService {
    void saveSchool(School school);
    List<School> fetchAllSchools();
    FullSchoolResponse fetchSchoolWithStudents(Long schoolId);
}
