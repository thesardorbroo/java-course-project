package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.ResultDto;

public interface ResultService {

    ResponseDto addResult(ResultDto resultDto);

    ResponseDto getResultById(Integer id);

    ResponseDto getAllResult();

    ResponseDto updateResult(ResultDto resultDto);

    ResponseDto deleteResultById(Integer id);
}
