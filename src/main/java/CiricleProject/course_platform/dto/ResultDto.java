package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDto {
    private Integer id;

    private StudentDto student;

    private Boolean status;

}
