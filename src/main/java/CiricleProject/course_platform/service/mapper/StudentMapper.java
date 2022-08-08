package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.StudentDto;
import CiricleProject.course_platform.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student toEntity (StudentDto studentDto);

    StudentDto toDto (Student student);
}
