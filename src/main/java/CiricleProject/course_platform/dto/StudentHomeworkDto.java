package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentHomeworkDto {
    private Integer id;
    private Integer studentId;
    private Integer homeworkId;
    private Boolean status;

    @Override
    public String toString() {
        return "StudentHomeworkDto{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", homeworkId=" + homeworkId +
                ", status=" + status +
                '}';
    }
}
