package CiricleProject.course_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelegramGroupDto {
    private Integer id;

    private String groupName;

    private CourseDto course;

    private String courseLink;
}
