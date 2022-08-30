package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.TelegramGroupDto;
import CiricleProject.course_platform.entity.TelegramGroup;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelegramGroupMapperImpl {

    public static TelegramGroupDto toDtoWithout(TelegramGroup telegramGroup){
        return TelegramGroupDto.builder()
                .id(telegramGroup.getId())
                .groupName(telegramGroup.getGroupName())
//                .course(CourseMapperImpl.toDtoWithoutMentor(telegramGroup.getCourse()))
                .courseLink(telegramGroup.getCourseLink())
                .build();
    }

    public static TelegramGroup toEntityWithout(TelegramGroupDto telegramGroupDto){
        return TelegramGroup.builder()
                .id(telegramGroupDto.getId())
                .groupName(telegramGroupDto.getGroupName())
//                .course(CourseMapperImpl.toEntityWithoutMentor(telegramGroupDto.getCourse()))
                .courseLink(telegramGroupDto.getCourseLink())
                .build();
    }
}
