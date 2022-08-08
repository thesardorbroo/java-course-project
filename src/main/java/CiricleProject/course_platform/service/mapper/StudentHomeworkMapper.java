package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.StudentHomeworkDto;
import CiricleProject.course_platform.entity.StudentHomework;
import org.mapstruct.Mapper;

@Mapper
public interface StudentHomeworkMapper {
    StudentHomework convertToStudentHomework(StudentHomeworkDto studentHomeworkDto);
    StudentHomeworkDto convertToStudentHomeworkDto(StudentHomework studentHomework);
}
