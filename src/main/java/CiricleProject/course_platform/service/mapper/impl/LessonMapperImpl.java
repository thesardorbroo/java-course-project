package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.LessonDto;
import CiricleProject.course_platform.entity.Lesson;
import lombok.Builder;
import lombok.Data;

import java.util.stream.Collectors;

@Data
@Builder
public class LessonMapperImpl {

    public static Lesson toEntityWithout(LessonDto lessonDto){

        return Lesson.builder()
                .id(lessonDto.getId())
//                .course(CourseMapperImpl.toEntityWithoutMentor(lessonDto.getCourse()))
                .lessonLength(lessonDto.getLessonLength())
                .lessonName(lessonDto.getLessonName())
                .videoAddress(lessonDto.getVideoAddress())
//                .result(ResultMapperImpl.toEntityWithout(lessonDto.getResult()))
//                .homeWork(lessonDto.getHomeWork().stream().map(HomeworkMapperImpl::toEntityWithout).collect(Collectors.toList()))
                .build();
    }

    public static LessonDto toDtoWithout(Lesson lesson){

        return LessonDto.builder()
                .id(lesson.getId())
//                .course(CourseMapperImpl.toDtoWithoutMentor(lesson.getCourse()))
                .lessonLength(lesson.getLessonLength())
                .lessonName(lesson.getLessonName())
                .videoAddress(lesson.getVideoAddress())
//                .result(ResultMapperImpl.toDtoWithout(lesson.getResult()))
                .homeWork(lesson.getHomeWork().stream().map(HomeworkMapperImpl::toDtoWithout).collect(Collectors.toList()))
                .build();

    }
}
