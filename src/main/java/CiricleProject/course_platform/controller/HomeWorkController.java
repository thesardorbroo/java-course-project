package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.HomeWorkDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.service.impl.HomeWorkServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/homeWork")
public class HomeWorkController {
    private final HomeWorkServiceImpl homeWorkService;
    @GetMapping("/{id}")
    public ResponseDto getHomeWorkById(@PathVariable Integer id){
      return   homeWorkService.getHomeWorkById(id);
    }
    @GetMapping
    public ResponseDto getAllHomeWork(){
        return homeWorkService.getAllHomeWork();
    }
    @PostMapping
    public ResponseDto addNewHomeWork(@RequestBody HomeWorkDto homeWorkDto){
        return homeWorkService.addNewHomeWork(homeWorkDto);
    }
    @PutMapping
    public ResponseDto updateHomeWork(@RequestBody HomeWorkDto homeWorkDto){
        return homeWorkService.updateHomeWork(homeWorkDto);
    }
    @DeleteMapping
    public ResponseDto deleteHomeWordById(@PathVariable Integer id){
        return homeWorkService.deleteHomeWorkById(id);
    }
}
