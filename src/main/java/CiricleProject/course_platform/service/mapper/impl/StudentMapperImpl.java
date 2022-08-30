package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.StudentDto;
import CiricleProject.course_platform.entity.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentMapperImpl {

    public static StudentDto toDtoWithout(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .age(student.getAge())
                .name(student.getName())
                .phoneNumber(student.getPhoneNumber())
                .username(student.getUsername())
                .gender(student.getGender())
                .password(student.getPassword())
                .studentHomework(null)
                .orders(null)
                .result(null)
                .build();
    }

    public static Student toEntityWithout(StudentDto studentDto){
        return Student.builder()
                .id(studentDto.getId())
                .age(studentDto.getAge())
                .name(studentDto.getName())
                .phoneNumber(studentDto.getPhoneNumber())
                .username(studentDto.getUsername())
                .gender(studentDto.getGender())
                .password(studentDto.getPassword())
                .studentHomework(null)
                .orders(null)
                .result(null)
                .build();
    }
}
