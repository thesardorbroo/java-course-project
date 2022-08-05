package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.dto.ResponseDto;


import java.util.List;


public interface CourseService {
    /**
    Add new Course to Response<list>
     * @param /CourseDto Info about student
     * @return ResponseDto - code -1 when exception occurs, 0 when all is OK.
     * */

    ResponseDto addCourse(CourseDto courseDto);

    ResponseDto<CourseDto> getCourse();


    ResponseDto updateCourse(CourseDto courseDto);

    ResponseDto deleteCourse(Integer id);


}
