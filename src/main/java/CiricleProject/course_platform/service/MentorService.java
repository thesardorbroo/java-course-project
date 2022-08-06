package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MentorService {
    ResponseDto addNewMentor(MentorDto mentorDto);
    ResponseDto getAllMentor();
    ResponseDto getMentorById(Integer id);

    ResponseDto updateMentor(MentorDto mentorDto);

    ResponseDto daleteMentorById(Integer id);

}
