package CiricleProject.course_platform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdersDto {

    private Integer id;

    private Integer courseId;

    private Integer studentId;

    private Boolean isPaid;
}
