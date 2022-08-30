package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.dto.ResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import CiricleProject.course_platform.service.impl.MentorServiceImpl;

@RestController
@RequestMapping("/mentor")
@RequiredArgsConstructor
public class MentorController {
    private final MentorServiceImpl mentorimpl;

    @GetMapping
    public ResponseDto getAllMentor(){
        return  mentorimpl.getAllMentor();
    }
    @GetMapping("/{id}")
    public ResponseDto getMentorByid(@PathVariable Integer id){

        return mentorimpl.getMentorById(id);
    }
    @PutMapping
    public ResponseDto updateMentor(@RequestBody MentorDto mentorDto){
        return mentorimpl.updateMentor(mentorDto);
    }
    @DeleteMapping
    public ResponseDto deleteMentor(@PathVariable Integer id){
        return mentorimpl.daleteMentorById(id);
    }
    @PostMapping
    public ResponseDto addTelegramGroup(@RequestBody MentorDto mentorDto){
        return mentorimpl.addNewMentor(mentorDto);
    }

}
