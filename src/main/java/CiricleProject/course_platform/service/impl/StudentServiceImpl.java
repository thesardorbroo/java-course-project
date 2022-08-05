package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.repository.StudentRepository;
import CiricleProject.course_platform.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

}
