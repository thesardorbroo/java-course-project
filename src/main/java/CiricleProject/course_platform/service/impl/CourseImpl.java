package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.repository.CourseRepository;
import CiricleProject.course_platform.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseImpl implements CourseService {

    private  CourseRepository courseRepository;

    @Override
    public ResponseDto addCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public ResponseDto<CourseDto> getCourse() {
        return null;
    }

    @Override
    public ResponseDto updateCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public ResponseDto deleteCourse(Integer id) {
        return null;
    }
}
