package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.HomeWorkDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.entity.HomeWork;
import CiricleProject.course_platform.mapper.HomeWorkMapper;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.HomeWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import CiricleProject.course_platform.service.HomeWorkServise;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeWorkServiceImpl implements HomeWorkServise {
    private final HomeWorkRepository homeWorkRepository;
    private final HomeWorkMapper homeWorkMapper;
    @Override
    public ResponseDto getAllHomeWork() {
        List<HomeWork> homeWork = homeWorkRepository.findAll();
        List<HomeWorkDto> list = homeWork.stream()
                .map(homeWorkMapper::convertToDto).toList();
        return ResponseMapper.getResponseDto(
                200,
                true,
                "Data is found",
                list
        );
    }

    @Override
    public ResponseDto getHomeWorkById(Integer id) {
        Optional<HomeWork> optional = homeWorkRepository.findById(id);
        if(optional.isPresent()){
            HomeWork homeWork = optional.get();
            HomeWorkDto homeWorkDto = homeWorkMapper.convertToDto(homeWork);
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is found",
                    homeWorkDto
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
    public ResponseDto updateHomeWork(HomeWorkDto homeWorkDto) {
        Optional<HomeWork> optional = homeWorkRepository.findById(homeWorkDto.getId());
        if(optional.isPresent()){
            HomeWork homeWork = optional.get();
            HomeWorkDto homeWorkDto1 = HomeWorkDto.builder()
                    .id(homeWorkDto.getId()!=null? homeWorkDto.getId():homeWork.getId())
                    .point(homeWorkDto.getPoint()!=null?homeWorkDto.getPoint():homeWork.getPoint())
                    .lessonId(homeWorkDto.getLessonId()!=null?homeWorkDto.getLessonId():homeWork.getLessonId())
                    .taskBody(homeWorkDto.getTaskBody()!=null?homeWorkDto.getTaskBody():homeWork.getTaskBody())
                    .extraTask(homeWork.getExtraTask()!=null?homeWorkDto.getExtraTask():homeWork.getExtraTask())
                    .build();
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is updated",
                    homeWorkDto1
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
    public ResponseDto deleteHomeWorkById(Integer id) {
        if(homeWorkRepository.existsById(id)){
            HomeWork homeWork = homeWorkRepository.findById(id).get();
            homeWorkRepository.delete(homeWork);
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is deleted",
                    homeWorkMapper.convertToDto(homeWork)
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
    public ResponseDto addNewHomeWork(HomeWorkDto homeWorkDto) {
        if(!homeWorkRepository.existsById(homeWorkDto.getId())){
            HomeWork homeWork = homeWorkRepository.save(homeWorkMapper.convertToEntity(homeWorkDto));
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Successully saved",
                    homeWorkMapper.convertToDto(homeWork)
            );

        }
        return ResponseMapper.getResponseDto(
                404,
                false,
                "Data is alrady exists",
                null
        );
    }
}
