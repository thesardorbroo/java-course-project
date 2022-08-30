package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.HomeWorkDto;
import CiricleProject.course_platform.entity.HomeWork;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HomeworkMapperImpl {

    public static HomeWorkDto toDtoWithout(HomeWork homeWork){
        return HomeWorkDto.builder()
                .id(homeWork.getId())
                .extraTask(homeWork.getExtraTask())
                .point(homeWork.getPoint())
                .taskBody(homeWork.getTaskBody())
                .lesson(null)
                .studentHomework(null)
                .build();
    }

    public static HomeWork toEntityWithout(HomeWorkDto homeWorkDto){
        return HomeWork.builder()
                .id(homeWorkDto.getId())
                .extraTask(homeWorkDto.getExtraTask())
                .point(homeWorkDto.getPoint())
                .taskBody(homeWorkDto.getTaskBody())
                .lesson(null)
                .studentHomework(null)
                .build();
    }
}
