package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentPointDto;

public interface StudentPointService {

    ResponseDto getStudentPointById(Integer id);

    ResponseDto getAllStudentPoint();

    ResponseDto deleteStudentPointById(Integer id);

    ResponseDto updateStudentPoint(StudentPointDto studentPointDto);

    ResponseDto addNewStudentPoint(StudentPointDto studentPointDto);
}
