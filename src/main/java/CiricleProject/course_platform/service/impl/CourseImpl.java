package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.entity.Course;
import CiricleProject.course_platform.mapper.CourseMapper;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.CourseRepository;
import CiricleProject.course_platform.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseImpl implements CourseService {

    private  CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    @Override
    public ResponseDto addCourse(CourseDto courseDto) {
        Course course = Course.builder()
                .id(courseDto.getId())
                .courseName(courseDto.getCourseName())
                .mentorId(courseDto.getMentorId())
                .coursePrice(courseDto.getCoursePrice())
                .during(courseDto.getDuring())
                .status(courseDto.getStatus())
                .build();

            courseRepository.save(course);

            return ResponseMapper.getResponseDto(200,true,"Succcesfuly add course",course);
    }



    @Override
    public ResponseDto getById(Integer id) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()){
            Course course = optional.get();
            CourseDto courseDto = courseMapper.convertToDto(course);
            return ResponseMapper.getResponseDto(200,true, "Data is found!", courseDto);
        }

        return ResponseMapper.getResponseDto(404,false, "Data isn't found!", null);

    }



    @Override
    public ResponseDto getCourse() {

        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = courses.stream()
                .map(courseMapper::convertToDto).toList();
        return ResponseMapper.getResponseDto(200,true, "Data is found!", courseDtos);

    }

    @Override
    public ResponseDto updateCourse(CourseDto courseDto) {

        Optional<Course> optional = courseRepository.findById(courseDto.getId());
        if(optional.isPresent()){
            Course course = optional.get();
            CourseDto courseDto1 = CourseDto.builder()
                    .id(courseDto.getId() != null? courseDto.getId() : course.getId())
                    .courseName(courseDto.getCourseName() != null? courseDto.getCourseName() : course.getCourseName())
                    .mentorId(courseDto.getMentorId() != null? courseDto.getMentorId() : course.getMentorId())
                    .status(courseDto.getStatus() != null? courseDto.getStatus() : course.getStatus())
                    .coursePrice((courseDto.getCoursePrice() != null? courseDto.getCoursePrice() : course.getCoursePrice()))
                    .build();

            return ResponseMapper.getResponseDto(200, true, "Data is updated!", courseDto1);
        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto deleteCourse(Integer id) {
        if(courseRepository.existsById(id)){
            Course course = courseRepository.findById(id).get();
            courseRepository.delete(course);
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is deleted!",
                    courseMapper.convertToDto(course));

        }
        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }
}
