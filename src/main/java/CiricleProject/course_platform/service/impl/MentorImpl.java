package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.entity.Mentor;
import CiricleProject.course_platform.mapper.MentorMapper;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.MentorRepository;
import CiricleProject.course_platform.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class  MentorImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

    @Override
    public ResponseDto addNewMentor(MentorDto mentorDto) {
        if(!mentorRepository.existsById(mentorDto.getId())){
            Mentor mentor = mentorRepository.save(mentorMapper.converToEntity(mentorDto));
                 return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Successully saved",
                         mentorMapper.convertToDto(mentor));

        }
        return ResponseMapper.getResponseDto(
                200,
                true,
                "Data is already exists",
                null);

    }

    @Override
    public ResponseDto getAllMentor() {
        List<Mentor> mentors = mentorRepository.findAll();
        List<MentorDto> list =  mentors.stream()
                .map(mentorMapper::convertToDto).toList();
        return ResponseMapper.getResponseDto(200,true,"Date is found",list);
    }

    @Override
    public ResponseDto getMentorById(Integer id) {
        Optional<Mentor> optional = mentorRepository.findById(id);
        if(optional.isPresent()){
            Mentor mentor =  optional.get();
            MentorDto mentorDto = mentorMapper.convertToDto(mentor);
            return ResponseMapper.getResponseDto(200,true,"Date is found", mentorDto);
        }
        return ResponseMapper.getResponseDto(404,false,"Date is not found",null);
    }

    @Override
    public ResponseDto updateMentor(MentorDto mentorDto) {
        Optional<Mentor> optional = mentorRepository.findById(mentorDto.getId());
        if(optional.isPresent()){
            Mentor mentor = optional.get();
            MentorDto mentorDto1 = MentorDto.builder()
                    .id(mentorDto.getId() != null ? mentorDto.getId() : mentor.getId())
                    .name(mentorDto.getName() != null ? mentorDto.getName() : mentor.getName())
                    .age(mentorDto.getAge() != null ? mentorDto.getAge() : mentor.getAge())
                    .experience(mentorDto.getExperience() != null ? mentorDto.getExperience():mentor.getExperiense())
                    .build();
            return ResponseMapper.getResponseDto(200,true ,"Date is found",mentorDto1);

        }
        return ResponseMapper.getResponseDto(404,false,"Data is not found",null);
    }

    @Override
    public ResponseDto daleteMentorById(Integer id) {
        if(mentorRepository.existsById(id)){
            Mentor mentor = mentorRepository.findById(id).get();
            mentorRepository.delete(mentor);
            return ResponseMapper.getResponseDto(200,
                    true,"Data is deleted!",
                    mentorMapper.convertToDto(mentor));
        }
        return ResponseMapper.getResponseDto(404,
                false,
                "Data is not found!",
                null);
    }

}
