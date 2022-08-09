package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.entity.Mentor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MentorMapper {
    Mentor toEntity(MentorDto mentorDto);
    MentorDto ToDto(Mentor mentor);
}
