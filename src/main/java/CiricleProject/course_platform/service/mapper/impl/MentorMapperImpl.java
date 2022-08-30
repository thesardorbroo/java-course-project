package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.entity.Mentor;
import lombok.Builder;
import lombok.Data;

import java.util.stream.Collectors;

@Data
@Builder
public class MentorMapperImpl {

    public static Mentor toEntityWithoutOther(MentorDto mentorDto){
        return Mentor.builder()
                .id(mentorDto.getId())
                .age(mentorDto.getAge())
                .key(mentorDto.getKey())
                .name(mentorDto.getName())
                .experience(mentorDto.getExperience())
//                .course(mentorDto.getCourse().stream().map(CourseMapperImpl::toEntityWithoutMentor).collect(Collectors.toList()))
                .build();
    }
    public static MentorDto toDtoWithoutOther(Mentor mentor){
        return MentorDto.builder()
                .id(mentor.getId())
                .age(mentor.getAge())
                .key(mentor.getKey())
                .name(mentor.getName())
                .experience(mentor.getExperience())
//                .course(mentor.getCourse().stream().map(CourseMapperImpl::toDtoWithoutMentor).collect(Collectors.toList()))
                .build();
    }

}
