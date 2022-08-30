package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.StudentHomeworkDto;
import CiricleProject.course_platform.entity.StudentHomework;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentHomeworkMapperImpl {

    public static StudentHomeworkDto toDtoWithout(StudentHomework studentHomework){
        return StudentHomeworkDto.builder()
                .id(studentHomework.getId())
                .student(StudentMapperImpl.toDtoWithout(studentHomework.getStudent()))
                .homeWork(HomeworkMapperImpl.toDtoWithout(studentHomework.getHomeWork()))
                .status(studentHomework.getStatus())
                .build();
    }

    public static StudentHomework toEntityWithout(StudentHomeworkDto studentHomeworkDto){
        return StudentHomework.builder()
                .id(studentHomeworkDto.getId())
                .student(StudentMapperImpl.toEntityWithout(studentHomeworkDto.getStudent()))
                .homeWork(HomeworkMapperImpl.toEntityWithout(studentHomeworkDto.getHomeWork()))
                .status(studentHomeworkDto.getStatus())
                .build();
    }
}
