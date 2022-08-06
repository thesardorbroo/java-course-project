package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentDto;
import CiricleProject.course_platform.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;
    @GetMapping("{id}")
    public ResponseDto getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    public ResponseDto getAllStudents(){
        return studentService.getAllStudent();
    }

    @PostMapping
    public ResponseDto addNewStudent(@RequestBody StudentDto studentDto){
        return studentService.addNewStudent(studentDto);
    }

    @PutMapping
    public ResponseDto updateStudent(StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudentById(id);
    }
}
