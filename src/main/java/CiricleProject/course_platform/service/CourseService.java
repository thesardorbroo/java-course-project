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

    /**
     * this method add course
     * @param courseDto
     * @return ResponseDto
     */

    ResponseDto addCourse(CourseDto courseDto);

    /**
     * this mthod get course(id)
     * @param id
     * @return ResponseDto
     */

    ResponseDto getById(Integer id);

    /**
     * this method get all courses
     * @return ResponseDto
     */

    ResponseDto  getCourse();

    /**
     * this method update course
     * @param courseDto
     * @return ResponseDto
     */

    ResponseDto updateCourse(CourseDto courseDto);

    /**
     * this method delete course(id)
     * @param id
     * @return ResponseDto
     */

    ResponseDto deleteCourse(Integer id);


}
