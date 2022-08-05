package CiricleProject.course_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {
    private Integer id;

    private String lessonName;

    private Integer courseId;

    private String lessonLength;

    private  String videoAddress;
}
