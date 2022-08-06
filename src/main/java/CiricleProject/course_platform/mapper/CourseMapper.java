package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    /**
     *
     * @param course
     * @return CourseDto
     */

    public CourseDto convertToDto(Course course){
        return CourseDto.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .coursePrice(course.getCoursePrice())
                .mentorId(course.getMentorId())
                .during(course.getDuring())
                .status(course.getStatus())
                .build();
    }

    /**
     *
     * @param courseDto
     * @return Course
     */

    public Course convertCourse(CourseDto courseDto){
        return Course.builder()
                .id(courseDto.getId())
                .courseName(courseDto.getCourseName())
                .mentorId(courseDto.getMentorId())
                .coursePrice(courseDto.getCoursePrice())
                .during(courseDto.getDuring())
                .status(courseDto.getStatus())
                .build();
    }

}
