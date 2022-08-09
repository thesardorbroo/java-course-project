package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.ResultDto;
import CiricleProject.course_platform.entity.Result;
import org.mapstruct.Mapper;

@Mapper
public interface ResultMapper {

    Result convertToResult(ResultDto resultDto);
    ResultDto convertToDto(Result result);
}
