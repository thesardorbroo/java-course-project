package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.LessonDto;
import CiricleProject.course_platform.entity.Lesson;
import org.mapstruct.Mapper;

@Mapper
public interface LessonMapper {
    Lesson toEntity (LessonDto lessonDto);
    LessonDto toDto (Lesson lesson);
}
