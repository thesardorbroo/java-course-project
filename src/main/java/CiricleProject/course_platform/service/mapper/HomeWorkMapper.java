package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.HomeWorkDto;
import CiricleProject.course_platform.entity.HomeWork;
import org.mapstruct.Mapper;

@Mapper
public interface HomeWorkMapper  {
    HomeWork ToEntity(HomeWorkDto homeWorkDto);
    HomeWorkDto ToDto(HomeWork homeWork);
}
