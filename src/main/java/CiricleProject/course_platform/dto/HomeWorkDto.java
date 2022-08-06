package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HomeWorkDto {
    private Integer id;
    private Integer lessonId;
    private String taskBody;
    private String extraTask;
    private Integer point;

    @Override
    public String toString() {
        return "HomeWorkDto{" +
                "id=" + id +
                ", lessonId=" + lessonId +
                ", taskBody='" + taskBody + '\'' +
                ", extraTask='" + extraTask + '\'' +
                ", point=" + point +
                '}';
    }
}
