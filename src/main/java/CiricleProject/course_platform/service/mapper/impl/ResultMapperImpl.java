package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.ResultDto;
import CiricleProject.course_platform.entity.Result;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultMapperImpl {

    public static ResultDto toDtoWithout(Result result){
        return ResultDto.builder()
                .id(result.getId())
                .status(result.getStatus())
                .student(null)
                .build();
    }


    public static Result toEntityWithout(ResultDto resultDto){
        return Result.builder()
                .id(resultDto.getId())
                .status(resultDto.getStatus())
                .student(null)
                .build();
    }
}
