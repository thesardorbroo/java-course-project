package CiricleProject.course_platform.controller;


import CiricleProject.course_platform.dto.LessonDto;
import CiricleProject.course_platform.dto.OrdersDto;
import CiricleProject.course_platform.dto.ResponseDto;

import CiricleProject.course_platform.service.impl.LessonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
    private final LessonServiceImpl lessontService;
    @GetMapping("{id}")
    public ResponseDto getLessonById(@PathVariable Integer id){
        return lessontService.getLessonById(id);
    }

    @GetMapping
    public ResponseDto getAllLessons(){
        return lessontService.getAllLessons();
    }

    @PostMapping
    public ResponseDto addNewLesson(@RequestBody LessonDto lessonDto){
        return lessontService.addNewLesson(lessonDto);
    }

    @PutMapping
    public ResponseDto updateLesson(LessonDto lessonDto){
        return lessontService.updateLesson(lessonDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteStudent(@PathVariable Integer id){
        return lessontService.deleteLessonById(id);
    }

}
