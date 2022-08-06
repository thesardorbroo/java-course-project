package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.TelegramGroupDto;
import org.springframework.stereotype.Service;

@Service
public interface TelegramGroupServise {
    ResponseDto addNewTelegramGroup(TelegramGroupDto telegramGroupDto);

    ResponseDto getAllTelegramGroup();
    ResponseDto getByIdTelegramGroup(Integer id);
    ResponseDto updateTelegramGroup(TelegramGroupDto telegramGroupDto);
    ResponseDto deleteByIdTelegramGroup(Integer id);
}
