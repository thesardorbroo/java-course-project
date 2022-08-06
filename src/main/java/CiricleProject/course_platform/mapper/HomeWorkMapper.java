package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.HomeWorkDto;
import CiricleProject.course_platform.entity.HomeWork;
import org.springframework.stereotype.Component;

@Component
public class HomeWorkMapper {
    public HomeWorkDto convertToDto(HomeWork homeWork){
        return HomeWorkDto.builder()
                .id(homeWork.getId())
                .lessonId(homeWork.getLessonId())
                .taskBody(homeWork.getTaskBody())
                .extraTask(homeWork.getExtraTask())
                .point(homeWork.getPoint())
                .build();

    }
    public HomeWork convertToEntity(HomeWorkDto homeWorkDto){
        return HomeWork.builder()
                .id(homeWorkDto.getId())
                .lessonId(homeWorkDto.getLessonId())
                .taskBody(homeWorkDto.getTaskBody())
                .extraTask(homeWorkDto.getExtraTask())
                .point(homeWorkDto.getPoint())
                .build();
    }

}
