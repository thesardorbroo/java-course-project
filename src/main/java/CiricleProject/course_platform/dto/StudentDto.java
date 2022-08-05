package CiricleProject.course_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private String phoneNumber;
}
