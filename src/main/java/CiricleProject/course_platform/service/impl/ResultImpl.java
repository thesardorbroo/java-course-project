package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.ResultDto;
import CiricleProject.course_platform.entity.Result;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.ResultRepository;
import CiricleProject.course_platform.service.ResultService;
import CiricleProject.course_platform.service.mapper.ResultMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final ResultMapperImpl resultMapper;

    @Override
    public ResponseDto addResult(ResultDto resultDto) {
        Result result = resultMapper.convertToResult(resultDto);
        resultRepository.save(result);

        return ResponseMapper.getResponseDto(200,true,"successfully saved",result);
    }

    @Override
    public ResponseDto getResultById(Integer id) {
        Optional<Result> optional = resultRepository.findById(id);
        if (optional.isPresent()){
            Result result = optional.get();
            ResultDto resultDtos = resultMapper.convertToDto(result);
            return ResponseMapper.getResponseDto(200,true,"successfully getById",resultDtos);
        }

        return ResponseMapper.getResponseDto(404,false,"Date not founded!",null);
    }

    @Override
    public ResponseDto getAllResult() {
        List<Result> resultList = resultRepository.findAll();
        List<ResultDto> resultDtos = resultList.stream()
                .map(resultMapper::convertToDto).toList();
        return ResponseMapper.getResponseDto(200,true,"successfully getById",resultDtos);
    }

    @Override
    public ResponseDto updateResult(ResultDto resultDto) {
        Optional<Result> optional = resultRepository.findById(resultDto.getId());
        if (optional.isPresent()){
            Result result = optional.get();
            ResultDto resultDto1 = ResultDto.builder()
                    .id(resultDto.getId() != null ? resultDto.getId() : result.getId())
//                    .studentId(resultDto.getStudentId() != null ? resultDto.getStudentId() : result.getStudentId())
//                    .lessonId(resultDto.getLessonId() != null ? resultDto.getLessonId() : result.getLessonId())
                    .status(resultDto.getStatus() != null ? resultDto.getStatus() : result.getStatus())
                    .build();
            return ResponseMapper.getResponseDto(200,true,"successfully getById",resultDto1);
        }

        return ResponseMapper.getResponseDto(404,false,"Date not founded!",null);
    }

    @Override
    public ResponseDto deleteResultById(Integer id) {
        if (resultRepository.existsById(id)){
            Result result = resultRepository.findById(id).get();
            resultRepository.delete(result);
            return ResponseMapper.getResponseDto(200,true,"successfully getById",resultMapper.convertToDto(result));
        }
        return ResponseMapper.getResponseDto(404,false,"Date not founded!",null);
    }
}
