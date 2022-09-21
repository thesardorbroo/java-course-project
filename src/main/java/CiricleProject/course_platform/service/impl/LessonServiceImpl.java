package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.LessonDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.entity.Lesson;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.LessonRepository;
import CiricleProject.course_platform.service.LessonService;
import CiricleProject.course_platform.service.mapper.LessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    private final LessonMapper lessonMapper;

    @Override
    public ResponseDto getLessonById(Integer id) {
        Optional<Lesson> optional = lessonRepository.findById(id);
        if(optional.isPresent()){
            Lesson lesson = optional.get();
            LessonDto lessonDto = lessonMapper.toDto(lesson);
            return ResponseMapper.getResponseDto(200,true, "Data is found!", lessonDto);
        }

        return ResponseMapper.getResponseDto(404,false, "Data is not found!", null);
    }


    @Override
    public ResponseDto getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        List<LessonDto> list = lessons.stream().map(lessonMapper::toDto).toList();
        if(list != null){
            return ResponseMapper.getResponseDto(200, true, "Data is found!", list);

        }
        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto updateLesson(LessonDto lessonDto) {
        Optional<Lesson> optional = lessonRepository.findById(lessonDto.getId());
        if(optional.isPresent()){
            Lesson lesson = optional.get();
            LessonDto demo2 = lessonDto.builder()
                    .id(lessonDto.getId() != null? lessonDto.getId() : lesson.getId())
                    .lessonName(lessonDto.getLessonName() != null? lessonDto.getLessonName() : lesson.getLessonName())
                    .courseId(lessonDto.getCourseId() != null? lessonDto.getCourseId() : lesson.getCourseId())
                    .lessonLength(lessonDto.getLessonLength() != null? lessonDto.getLessonLength() : lesson.getLessonLength())
                    .videoAddress(lessonDto.getVideoAddress() != null? lessonDto.getVideoAddress() : lesson.getVideoAddress())
                    .build();

            return ResponseMapper.getResponseDto(200, true, "Data is updated!", demo2);
        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto deleteLessonById(Integer id) {
        if(lessonRepository.existsById(id)){
            Lesson lesson= lessonRepository.findById(id).get();
            lessonRepository.delete(lesson);
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is deleted!",
                    lessonMapper.toDto(lesson));

        }
        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto addNewLesson(LessonDto lessonDto) {
        if(!lessonRepository.existsById(lessonDto.getId())){
            Lesson lesson = lessonRepository.save(lessonMapper.toEntity(lessonDto));
            return ResponseMapper.getResponseDto(200, true, "Successully saved!", lessonMapper.toDto(lesson));
        }
        return ResponseMapper.getResponseDto(404, false, "Data is already exists!", null);
    }
}

