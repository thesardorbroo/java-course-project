package CiricleProject.course_platform.dto;

import CiricleProject.course_platform.entity.HomeWork;
import CiricleProject.course_platform.entity.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {
    private Integer id;

    private String lessonName;

    private CourseDto course;

    private String lessonLength;

    private  String videoAddress;

//    private ResultDto result;

    private List<HomeWorkDto> homeWork;

}
