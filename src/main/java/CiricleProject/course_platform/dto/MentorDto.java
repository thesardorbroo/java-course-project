package CiricleProject.course_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.stream.Stream;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentorDto {
    private Integer id;
    private String name;
    private Integer age;
    private Integer experience;
    private String key;

    @Override
    public String toString() {
        return "MentorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", key=" + key +
                '}';
    }

}
