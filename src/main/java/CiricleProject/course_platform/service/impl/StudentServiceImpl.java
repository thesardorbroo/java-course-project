package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.StudentDto;
import CiricleProject.course_platform.entity.Student;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.service.mapper.StudentMapper;
import CiricleProject.course_platform.repository.StudentRepository;
import CiricleProject.course_platform.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Override
    public ResponseDto getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            Student student = optional.get();
            StudentDto studentDto = studentMapper.toDto(student);
            return ResponseMapper.getResponseDto(200,true, "Data is found!", studentDto);
        }

        return ResponseMapper.getResponseDto(404,false, "Data is not found!", null);
    }

    @Override
    public ResponseDto getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> list = students.stream()
                .map(studentMapper::toDto).toList();

        return ResponseMapper.getResponseDto(200, true, "Data is found!", list);
    }

    @Override
    public ResponseDto updateStudent(StudentDto studentDto) {
        Optional<Student> optional = studentRepository.findById(studentDto.getId());
        if(optional.isPresent()){
            Student student = optional.get();
            StudentDto demo = StudentDto.builder()
                    .id(studentDto.getId() != null? studentDto.getId() : student.getId())
                    .name(studentDto.getName() != null? studentDto.getName() : student.getName())
                    .age(studentDto.getAge() != null? studentDto.getAge() : student.getAge())
                    .gender(studentDto.getGender() != null? studentDto.getGender() : student.getGender())
                    .phoneNumber(studentDto.getPhoneNumber() != null? studentDto.getPhoneNumber() : student.getPhoneNumber())
                    .build();

            return ResponseMapper.getResponseDto(200, true, "Data is updated!", demo);
        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto deleteStudentById(Integer id) {
        if(studentRepository.existsById(id)){
            Student student = studentRepository.findById(id).get();
            studentRepository.delete(student);
            return ResponseMapper.getResponseDto(
                    200,
                    true,
                    "Data is deleted!",
                    studentMapper.toDto(student));

        }
        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto addNewStudent(StudentDto studentDto) {
        if (!studentRepository.existsByUsername(studentDto.getUsername())) {
            Student student = studentRepository.save(studentMapper.toEntity(studentDto));
            return ResponseMapper.getResponseDto(200, true, "Successully saved!", studentMapper.toDto(student));
        }

        return ResponseMapper.getResponseDto(404, false, "Data is already exists!", null);
    }
}
