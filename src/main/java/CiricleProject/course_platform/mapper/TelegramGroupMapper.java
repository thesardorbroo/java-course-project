package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.TelegramGroupDto;
import CiricleProject.course_platform.entity.TelegramGroup;
import org.springframework.stereotype.Component;

@Component
public class TelegramGroupMapper {
    public TelegramGroupDto convertToDto(TelegramGroup telegramGroup){
        return TelegramGroupDto.builder()
                .id(telegramGroup.getId())
                .groupName(telegramGroup.getGroupName())
                .courseId(telegramGroup.getCourseId())
                .courseLink(telegramGroup.getCourseLink())
                .build();
    }
    public TelegramGroup converToEntity(TelegramGroupDto telegramGroupDto){
        return TelegramGroup.builder()
                .id(telegramGroupDto.getId())
                .groupName(telegramGroupDto.getGroupName())
                .courseId(telegramGroupDto.getCourseId())
                .courseLink(telegramGroupDto.getCourseLink())
                .build();
    }
}
