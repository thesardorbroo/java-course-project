package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.StudentPointDto;
import CiricleProject.course_platform.entity.StudentPoint;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentPointMapperImpl {

    public static StudentPointDto toDtoWithout(StudentPoint studentPoint){
        return StudentPointDto.builder()
                .id(studentPoint.getId())
                .point(studentPoint.getPoint())
                .student(StudentMapperImpl.toDtoWithout(studentPoint.getStudent()))
                .lesson(LessonMapperImpl.toDtoWithout(studentPoint.getLesson()))
                .build();
    }

    public static StudentPoint toEntity(StudentPointDto studentPointDto){
        return StudentPoint.builder()
                .id(studentPointDto.getId())
                .point(studentPointDto.getPoint())
                .student(StudentMapperImpl.toEntityWithout(studentPointDto.getStudent()))
                .lesson(LessonMapperImpl.toEntityWithout(studentPointDto.getLesson()))
                .build();
    }
}
