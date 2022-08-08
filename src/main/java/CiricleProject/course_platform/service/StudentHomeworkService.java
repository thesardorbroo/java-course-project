package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentHomeworkDto;
import CiricleProject.course_platform.mapper.ResponseMapper;

public interface StudentHomeworkService {
    ResponseDto addStudentHomework(StudentHomeworkDto studentHomeworkDto);

    ResponseDto getByIdStudentHomework(Integer id);

    ResponseDto getAllStudentHomework();

    ResponseDto updateStudentHomework(StudentHomeworkDto studentHomeworkDto);

    ResponseDto deleteByIdStudentHomework(Integer id);
}
