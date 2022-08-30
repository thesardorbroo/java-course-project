package CiricleProject.course_platform.dto;

import CiricleProject.course_platform.entity.Lesson;
import CiricleProject.course_platform.entity.Mentor;
import CiricleProject.course_platform.entity.Orders;
import CiricleProject.course_platform.entity.TelegramGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Integer id;
    private String courseName;
    private MentorDto mentor;
    private Double coursePrice;
    private Integer during;
    private Boolean status;

    private TelegramGroupDto telegramGroup;

    private List<OrdersDto> orders;

    private List<LessonDto> lessons;

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", mentorId=" + mentor +
                ", coursePrice=" + coursePrice +
                ", during=" + during +
                ", status='" + status + '\'' +
                '}';
    }
}
