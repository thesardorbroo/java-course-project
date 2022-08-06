package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.impl.CourseImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "course")
public class CourseController {


    private final CourseImpl courseimpl;


    public CourseController(CourseImpl courseimpl) {
        this.courseimpl = courseimpl;
    }

    @PostMapping
    public ResponseDto addCourse(CourseDto courseDto){

        return courseimpl.addCourse(courseDto);
    }

    @GetMapping("/{id}")
    public ResponseDto getById(@PathVariable Integer id){
        return courseimpl.getById(id);
    }

    @GetMapping
    public ResponseDto getCourse(){

        return courseimpl.getCourse();
    }

    @PatchMapping
    public ResponseDto updateCourse(CourseDto courseDto){

        return courseimpl.updateCourse(courseDto);
    }

    @DeleteMapping
    public ResponseDto deleteCourse(Integer id){

        return courseimpl.deleteCourse(id);
    }

}
