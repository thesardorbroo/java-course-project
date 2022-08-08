package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.TelegramGroupDto;
import CiricleProject.course_platform.entity.TelegramGroup;
import org.mapstruct.Mapper;

@Mapper
public interface TelegramGroupMapper {
    TelegramGroup toEntity(TelegramGroupDto telegramGroupDto);
    TelegramGroupDto ToDto(TelegramGroup telegramGroup);
}
