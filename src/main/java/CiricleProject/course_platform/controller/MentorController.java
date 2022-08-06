package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.service.impl.MentorImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mentor")
public class MentorController {
    private final MentorImpl mentorimpl;
    public MentorController(MentorImpl mentorimpl){
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

}
