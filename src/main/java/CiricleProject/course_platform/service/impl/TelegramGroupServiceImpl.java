package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.TelegramGroupDto;
import CiricleProject.course_platform.entity.TelegramGroup;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.TelegramGroupRepository;
import CiricleProject.course_platform.service.TelegramGroupService;
import CiricleProject.course_platform.service.mapper.TelegramGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelegramGroupServiceImpl implements TelegramGroupService {
    private final TelegramGroupMapper telegramGroupMapper;
    private final TelegramGroupRepository telegramGroupRepository;

    @Override
    public ResponseDto addNewTelegramGroup(TelegramGroupDto telegramGroupDto) {
        if(!telegramGroupRepository.existsById(telegramGroupDto.getId())){
            TelegramGroup telegramGroup = telegramGroupRepository.save(telegramGroupMapper.toEntity(telegramGroupDto));
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Successully saved",
                    telegramGroupMapper.ToDto(telegramGroup));
        }
        return ResponseMapper.getResponseDto(
                404,
                false,
                "Data is already exists",
                null);
    }


    @Override
    public ResponseDto getAllTelegramGroup() {
        List<TelegramGroup> list = telegramGroupRepository.findAll();
        List<TelegramGroupDto> telegramGroupDtos = list.stream()
                .map(telegramGroupMapper::ToDto).toList();
        return ResponseMapper.getResponseDto(
                200,
                true,
                "Data is found",
                telegramGroupDtos);
    }

    @Override
    public ResponseDto getByIdTelegramGroup(Integer id) {
        Optional<TelegramGroup> optional = telegramGroupRepository.findById(id);
        if(optional.isPresent()){
            TelegramGroup telegramGroup = optional.get();
            TelegramGroupDto telegramGroupDto = telegramGroupMapper.ToDto(telegramGroup);
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is found",
                    telegramGroupDto
            );
        }
        return ResponseMapper.getResponseDto(
                404,
                false,
                "Data is not found",
                null
        );
    }

    @Override
    public ResponseDto updateTelegramGroup(TelegramGroupDto telegramGroupDto) {
        Optional<TelegramGroup> optional = telegramGroupRepository.findById(telegramGroupDto.getId());
        if(optional.isPresent()){
            TelegramGroup telegramGroup = optional.get();
            TelegramGroupDto telegramGroupDto1  = TelegramGroupDto.builder()
                    .id(telegramGroupDto.getId() !=null ? telegramGroupDto.getId():telegramGroup.getId())
                    .groupName(telegramGroupDto.getGroupName()!=null?telegramGroupDto.getGroupName():telegramGroup.getGroupName())
                    .courseId(telegramGroupDto.getCourseId()!=null? telegramGroupDto.getCourseId():telegramGroup.getCourseId())
                    .courseLink(telegramGroupDto.getCourseLink()!=null?telegramGroupDto.getCourseLink():telegramGroup.getCourseLink())
                    .build();
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is found",
                    telegramGroupDto1
            );
        }
        return ResponseMapper.getResponseDto(
                404,
                false,
                "Data is not found",
                null);
    }

    @Override
    public ResponseDto deleteByIdTelegramGroup(Integer id) {
        if(telegramGroupRepository.existsById(id)){
            TelegramGroup telegramGroup = telegramGroupRepository.findById(id).get();
            telegramGroupRepository.delete(telegramGroup);
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is found",
                    telegramGroupMapper.ToDto(telegramGroup)
            );
        }
        return ResponseMapper.getResponseDto(
                404,
                false,
                "Data is not found",
               null);
    }
}
