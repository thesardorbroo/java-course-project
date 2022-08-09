package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.CourseDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.entity.Course;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.CourseRepository;
import CiricleProject.course_platform.service.CourseService;
import CiricleProject.course_platform.service.mapper.CourseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapperImpl courseMapper;


    @Override
    public ResponseDto addCourse(CourseDto courseDto) {
        System.out.println(courseDto);
        if (!courseRepository.existsByCourseName(courseDto.getCourseName())) {
            Course course = courseMapper.toCourse(courseDto);
            courseRepository.save(course);

            return ResponseMapper.getResponseDto(200, true, "Succcesfuly add course", course);

        }

        return ResponseMapper.getResponseDto(404, false, "Data is already exists!", null);
    }



    @Override
    public ResponseDto getById(Integer id) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()){
            Course course = optional.get();
            CourseDto courseDto = courseMapper.toDto(course);
            return ResponseMapper.getResponseDto(200,true, "Data is found!", courseDto);
        }

        return ResponseMapper.getResponseDto(404,false, "Data isn't found!", null);

    }



    @Override
    public ResponseDto getCourse() {

        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = courses.stream()
                .map(courseMapper::toDto).toList();
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
                    courseMapper.toDto(course));

        }
        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }
}
