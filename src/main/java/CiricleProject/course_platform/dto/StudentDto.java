package CiricleProject.course_platform.dto;

import CiricleProject.course_platform.entity.Orders;
import CiricleProject.course_platform.entity.Result;
import CiricleProject.course_platform.entity.StudentHomework;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

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

    private String username;

    private String password;

    private List<StudentHomeworkDto> studentHomework;

    private List<ResultDto> result;

    private List<OrdersDto> orders;
}
