package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.TelegramGroupDto;

public interface TelegramGroupService {

        ResponseDto addNewTelegramGroup(TelegramGroupDto telegramGroupDto);

        ResponseDto getAllTelegramGroup();
        ResponseDto getByIdTelegramGroup(Integer id);
        ResponseDto updateTelegramGroup(TelegramGroupDto telegramGroupDto);
        ResponseDto deleteByIdTelegramGroup(Integer id);

}
