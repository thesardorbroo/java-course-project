package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.StudentPointDto;
import CiricleProject.course_platform.entity.StudentPoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentPointMapper {

    StudentPointDto toDto(StudentPoint studentPoint);

    StudentPoint toEntity(StudentPointDto studentPointDto);
}
