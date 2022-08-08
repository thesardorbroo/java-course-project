package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentHomeworkDto;
import CiricleProject.course_platform.service.impl.StudentHomeworkServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student_homework")
public class StudentHomeworkController {

    private final StudentHomeworkServiceImpl service;

    public StudentHomeworkController(StudentHomeworkServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseDto addStudentHomework(@RequestBody StudentHomeworkDto studentHomeworkDto){
        return service.addStudentHomework(studentHomeworkDto);
    }

    @GetMapping("/{id}")
    public ResponseDto getByIdStudentHomework(@PathVariable Integer id){
        return service.getByIdStudentHomework(id);
    }

    @GetMapping
    public ResponseDto getAllStudentHomework(){
        return service.getAllStudentHomework();
    }

    @PatchMapping
    public ResponseDto updateStudentHomework(StudentHomeworkDto studentHomeworkDto){
        return service.updateStudentHomework(studentHomeworkDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteStudentHomework(@PathVariable Integer id){
        return service.deleteByIdStudentHomework(id);
    }
}
