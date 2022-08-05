package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.StudentDto;
import CiricleProject.course_platform.entity.Student;
import CiricleProject.course_platform.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto convertToDto(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .gender(student.getGender())
                .phoneNumber(student.getPhoneNumber())
                .build();
    }

    public Student convertToEntity(StudentDto studentDto){
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .age(studentDto.getAge())
                .gender(studentDto.getGender())
                .phoneNumber(studentDto.getPhoneNumber())
                .build();
    }


}
