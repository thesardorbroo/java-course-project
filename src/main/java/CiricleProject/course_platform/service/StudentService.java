package CiricleProject.course_platform.service;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentDto;
import org.springframework.stereotype.Service;


@Service
public interface StudentService {

    ResponseDto getStudentById(Integer id);

    ResponseDto getAllStudent();

    ResponseDto updateStudent(StudentDto studentDto);

    ResponseDto deleteStudentById(Integer id);

    ResponseDto addNewStudent(StudentDto studentDto);
}
