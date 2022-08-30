package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentPointDto {

    private Integer id;

    private StudentDto student;

    private LessonDto lesson;

    private Integer point;

}
