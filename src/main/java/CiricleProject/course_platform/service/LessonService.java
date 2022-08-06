package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.LessonDto;
import CiricleProject.course_platform.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface LessonService {

    ResponseDto getLessonById(Integer id);

    ResponseDto getAllLessons();

    ResponseDto updateLesson(LessonDto lessonDto);

    ResponseDto deleteLessonById(Integer id);
}

