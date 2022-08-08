package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.LessonDto;
import CiricleProject.course_platform.entity.Lesson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LessonModelMapper {

    private final ModelMapper mapper;

    public LessonModelMapper() {
        this.mapper = new ModelMapper();
    }


    public LessonDto toDto(Lesson lesson){
        return mapper.map(lesson, LessonDto.class);
    }

    public Lesson toEntity(LessonDto lessonDto){
        return mapper.map(lessonDto, Lesson.class);
    }
}
