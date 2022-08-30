package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.entity.Course;
import lombok.Builder;
import lombok.Data;

import java.util.stream.Collectors;

@Data
@Builder
public class CourseMapperImpl {

    public static CourseDto toDtoWithoutMentor(Course course){
        return CourseDto.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .coursePrice(course.getCoursePrice())
                .during(course.getDuring())
                .status(course.getStatus())
                .mentor(MentorMapperImpl.toDtoWithoutOther(course.getMentor()))
//                .telegramGroup(TelegramGroupMapperImpl.toDtoWithout(course.getTelegramGroup()))
                .orders(course.getOrders().stream().map(OrdersMapperImpl::toDtoWithout).collect(Collectors.toList()))
                .lessons(course.getLessons().stream().map(LessonMapperImpl::toDtoWithout).collect(Collectors.toList()))
                .build();
    }

    public static Course toEntityWithoutMentor(CourseDto courseDto){
        return Course.builder()
                .id(courseDto.getId())
                .courseName(courseDto.getCourseName())
                .coursePrice(courseDto.getCoursePrice())
                .during(courseDto.getDuring())
                .status(courseDto.getStatus())
                .mentor(MentorMapperImpl.toEntityWithoutOther(courseDto.getMentor()))
                .telegramGroup(TelegramGroupMapperImpl.toEntityWithout(courseDto.getTelegramGroup()))
                .orders(courseDto.getOrders().stream().map(OrdersMapperImpl::toEntityWithout).collect(Collectors.toList()))
                .lessons(courseDto.getLessons().stream().map(LessonMapperImpl::toEntityWithout).collect(Collectors.toList()))
                .build();
    }
}
