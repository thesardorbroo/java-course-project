package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDto {
    private Integer id;
    private Integer studentId;
    private Integer lessonId;
    private Boolean status;

    @Override
    public String toString() {
        return "ResultDto{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", lessonId=" + lessonId +
                ", status=" + status +
                '}';
    }
}
