package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {
    private Integer id;
    private String courseName;
    private Integer mentorId;
    private Double coursePrice;
    private Integer during;
    private Boolean status;

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", mentorId=" + mentorId +
                ", coursePrice=" + coursePrice +
                ", during=" + during +
                ", status='" + status + '\'' +
                '}';
    }
}
