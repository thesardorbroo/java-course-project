package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.dto.ResponseDto;

import org.springframework.web.bind.annotation.*;
import CiricleProject.course_platform.impl.MentorServiceImpl;

@RestController
@RequestMapping("mentor")
public class MentorController {
    private final MentorServiceImpl mentorimpl;
    public MentorController(MentorServiceImpl mentorimpl){

        this.mentorimpl = mentorimpl;
    }
    @GetMapping
    public ResponseDto getAllMentor(){
        return  mentorimpl.getAllMentor();
    }
    @GetMapping
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
    @PatchMapping
    public ResponseDto addTelegramGroup(@RequestBody MentorDto mentorDto){
        return mentorimpl.addNewMentor(mentorDto);
    }

}
