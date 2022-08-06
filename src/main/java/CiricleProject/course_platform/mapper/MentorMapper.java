package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.entity.Mentor;
import org.springframework.stereotype.Component;

@Component
public class MentorMapper {
    public MentorDto convertToDto(Mentor mentor){
        return MentorDto.builder()
                .id(mentor.getId())
                .name(mentor.getName())
                .age(mentor.getAge())
                .experience(mentor.getExperiense())
                .build();

    }
    public Mentor converToEntity(MentorDto mentorDto){
        return Mentor.builder()
                .id(mentorDto.getId())
                .name(mentorDto.getName())
                .age(mentorDto.getAge())
                .experiense(mentorDto.getExperience())
                .build();
    }
}
