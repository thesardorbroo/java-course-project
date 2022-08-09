package CiricleProject.course_platform.controller;


import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.ResultDto;
import CiricleProject.course_platform.service.impl.ResultImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/result")
public class ResultController {
    private final ResultImpl result;

    @PostMapping
    public ResponseDto addResult(@RequestBody ResultDto resultDto){
        return result.addResult(resultDto);
    }

    @GetMapping("/{id}")
    public ResponseDto getById(@RequestParam Integer id){
        return result.getResultById(id);
    }

    @GetMapping
    public ResponseDto getAll(){
        return result.getAllResult();
    }

    @PostMapping
    public ResponseDto updateResult(@RequestBody ResultDto resultDto){
        return result.updateResult(resultDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteResult(@RequestParam Integer id){
        return result.deleteResultById(id);
    }
}
