package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.dto.ResponseDto;

public interface MentorService {
    ResponseDto<MentorDto> addNewMentor(MentorDto mentorDto);
    ResponseDto getAllMentor();
    ResponseDto getMentorById(Integer id);

    ResponseDto updateMentor(MentorDto mentorDto);

    ResponseDto daleteMentorById(Integer id);

}
