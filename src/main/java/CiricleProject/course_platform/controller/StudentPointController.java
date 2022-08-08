package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentPointDto;
import CiricleProject.course_platform.service.impl.StudentPointServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-point")
@RequiredArgsConstructor
public class StudentPointController {

    private final StudentPointServiceImpl service;

    @GetMapping
    public ResponseDto getAllStudentPoint(){
        return service.getAllStudentPoint();
    }

    @GetMapping("/{id}")
    public ResponseDto getStudentPointById(@PathVariable Integer id){
        return service.getStudentPointById(id);
    }

    @PostMapping
    public ResponseDto addNewStudentPoint(@RequestBody StudentPointDto studentPointDto){
        return service.addNewStudentPoint(studentPointDto);
    }

    @PutMapping
    public ResponseDto updateStudentPoint(@RequestBody StudentPointDto studentPointDto){
        return service.updateStudentPoint(studentPointDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteStudentPointById(@PathVariable Integer id) {
        return service.deleteStudentPointById(id);
    }

}
