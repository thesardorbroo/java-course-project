package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentPointDto;
import CiricleProject.course_platform.entity.StudentPoint;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.StudentPointRepository;
import CiricleProject.course_platform.service.StudentPointService;
import CiricleProject.course_platform.service.mapper.StudentPointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentPointServiceImpl implements StudentPointService {

    private final StudentPointRepository repository;

    private final StudentPointMapper mapper;

    @Override
    public ResponseDto getStudentPointById(Integer id) {
        if(repository.existsById(id)){
            StudentPoint studentPoint = repository.findById(id).get();
            return ResponseMapper.getResponseDto(200, true, "Data is found!", mapper.toDto(studentPoint));
        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto getAllStudentPoint() {
        List<StudentPoint> studentPoints = repository.findAll();
        List<StudentPointDto> list = studentPoints.stream()
                .map(mapper::toDto)
                .toList();

        return ResponseMapper.getResponseDto(200, true, "Data is found!", list);
    }

    @Override
    public ResponseDto deleteStudentPointById(Integer id) {
        if(repository.existsById(id)){
            StudentPoint studentPoint = repository.findById(id).get();
            repository.deleteById(id);

            return ResponseMapper.getResponseDto(200, true, "Successfully deleted!", mapper.toDto(studentPoint));

        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto updateStudentPoint(StudentPointDto studentPointDto) {
        if(repository.existsById(studentPointDto.getId())){
            StudentPoint studentPoint = repository.findById(studentPointDto.getId()).get();
            studentPoint = StudentPoint.builder()
                    .id(studentPointDto.getId() != null? studentPointDto.getId() : studentPoint.getId())
                    .studentId(studentPointDto.getStudentId() != null? studentPointDto.getStudentId() : studentPoint.getStudentId())
                    .lessonId(studentPointDto.getLessonId() != null? studentPointDto.getLessonId() : studentPoint.getLessonId())
                    .point(studentPointDto.getPoint() != null? studentPointDto.getPoint() : studentPoint.getPoint())
                    .build();

            repository.save(studentPoint);

            return ResponseMapper.getResponseDto(200, true, "Successfully updated!", mapper.toDto(studentPoint));
        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto addNewStudentPoint(StudentPointDto studentPointDto) {
        if(!repository.existsById(studentPointDto.getId())){
            StudentPoint studentPoint = mapper.toEntity(studentPointDto);
            studentPoint = repository.save(studentPoint);

            return ResponseMapper.getResponseDto(200, true, "Successfully added!", mapper.toDto(studentPoint));
        }

        return ResponseMapper.getResponseDto(404, false, "Data is already exists!", null);
    }
}
