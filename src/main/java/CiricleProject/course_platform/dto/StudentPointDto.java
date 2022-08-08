package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentPointDto {

    private Integer id;

    private Integer studentId;

    private Integer lessonId;

    private Integer point;

}
