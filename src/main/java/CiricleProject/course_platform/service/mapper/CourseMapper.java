package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.entity.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
     Course toCourse(CourseDto courseDto);
     CourseDto toDto(Course course);
}
