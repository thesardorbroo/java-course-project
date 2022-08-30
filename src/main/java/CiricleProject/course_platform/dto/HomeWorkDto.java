package CiricleProject.course_platform.dto;

import CiricleProject.course_platform.entity.Lesson;
import CiricleProject.course_platform.entity.StudentHomework;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeWorkDto {
    private Integer id;
    private LessonDto lesson;
    private String taskBody;
    private String extraTask;
    private Integer point;

    private List<StudentHomeworkDto> studentHomework;

    @Override
    public String toString() {
        return "HomeWorkDto{" +
                "id=" + id +
                ", lessonId=" + lesson +
                ", taskBody='" + taskBody + '\'' +
                ", extraTask='" + extraTask + '\'' +
                ", point=" + point +
                '}';
    }
}
