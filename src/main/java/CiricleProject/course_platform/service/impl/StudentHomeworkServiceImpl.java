package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentHomeworkDto;
import CiricleProject.course_platform.entity.StudentHomework;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.StudentHomeworkRepository;
import CiricleProject.course_platform.service.StudentHomeworkService;
import CiricleProject.course_platform.service.mapper.StudentHomeworkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentHomeworkServiceImpl implements StudentHomeworkService {

    public final StudentHomeworkMapper studentHomeworkMapper;
    public final StudentHomeworkRepository studentHomeworkRepository;

    @Override
    public ResponseDto addStudentHomework(StudentHomeworkDto studentHomeworkDto) {
        StudentHomework studentHomework = studentHomeworkMapper.convertToStudentHomework(studentHomeworkDto);
        studentHomeworkRepository.save(studentHomework);

        return ResponseMapper.getResponseDto(200,true,"successfully saved",studentHomework);
    }

    @Override
    public ResponseDto getByIdStudentHomework(Integer id) {
        Optional<StudentHomework> optional = studentHomeworkRepository.findById(id);
        if (optional.isPresent()){
            StudentHomework studentHomework = optional.get();
            StudentHomeworkDto studentHomeworkDto = studentHomeworkMapper.convertToStudentHomeworkDto(studentHomework);
            return ResponseMapper.getResponseDto(200,true,"Succesfuly getById",studentHomeworkDto);
        }

        return ResponseMapper.getResponseDto(404,false,"Data not founded",null);
    }

    @Override
    public ResponseDto getAllStudentHomework() {
        List<StudentHomework> studentHomeworks = studentHomeworkRepository.findAll();
        List<StudentHomeworkDto> studentHomeworkDto = studentHomeworks.stream()
                .map(studentHomeworkMapper::convertToStudentHomeworkDto).toList();
        return ResponseMapper.getResponseDto(200,true,"succesfully getAll",studentHomeworkDto);
    }

    @Override
    public ResponseDto updateStudentHomework(StudentHomeworkDto studentHomeworkDto) {
        Optional<StudentHomework> optional = studentHomeworkRepository.findById(studentHomeworkDto.getId());
        if (optional.isPresent()){
            StudentHomework studentHomework = optional.get();
            StudentHomeworkDto studentHomeworkDto1 = StudentHomeworkDto.builder()
                    .id(studentHomeworkDto.getId() != null ? studentHomeworkDto.getId() : studentHomework.getId())
//                    .studentId(studentHomeworkDto.getStudentId() != null ? studentHomeworkDto.getStudentId() : studentHomework.getStudentId())
//                    .homeworkId(studentHomeworkDto.getHomeworkId() != null ? studentHomeworkDto.getHomeworkId() : studentHomework.getHomeworkId())
                    .status(studentHomeworkDto.getStatus() != null ? studentHomeworkDto.getStatus() : studentHomework.getStatus())
                    .build();
            return ResponseMapper.getResponseDto(200,true,"successfully update",studentHomeworkDto1);
        }
        return ResponseMapper.getResponseDto(404,false,"Data not founded",null);
    }

    @Override
    public ResponseDto deleteByIdStudentHomework(Integer id) {
        if (studentHomeworkRepository.existsById(id)){
            StudentHomework studentHomework = studentHomeworkRepository.findById(id).get();
            studentHomeworkRepository.delete(studentHomework);
            return ResponseMapper.getResponseDto(200,true,"successfully delete",studentHomeworkMapper.convertToStudentHomeworkDto(studentHomework));
        }

        return ResponseMapper.getResponseDto(404,false,"Data not founded",null);
    }


}
