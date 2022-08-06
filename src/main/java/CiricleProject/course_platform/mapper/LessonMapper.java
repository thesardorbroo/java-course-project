package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.LessonDto;
import CiricleProject.course_platform.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {

    public LessonDto convertToDto(Lesson lesson){
        return LessonDto.builder()
                .id(lesson.getId())
                .lessonName(lesson.getLessonName())
                .courseId(lesson.getCourseId())
                .lessonLength(lesson.getLessonLength())
                .videoAddress(lesson.getVideoAddress())
                .build();

    }

    public Lesson convertToEntity(LessonDto lessonDto){
        return Lesson.builder()
                .id(lessonDto.getId())
                .lessonName(lessonDto.getLessonName())
                .courseId(lessonDto.getCourseId())
                .lessonLength(lessonDto.getLessonLength())
                .videoAddress(lessonDto.getVideoAddress())
                .build();
    }


}
