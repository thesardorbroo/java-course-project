package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.charset.CodingErrorAction;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "mentor")
public class MentorEntity {
    @Id
    @GeneratedValue(generator = "mentor_seq")
    @SequenceGenerator(name = "mentor_seq",sequenceName = "mentor_id_seq",allocationSize = 1)
    private Integer id;
    private String name;
    private Integer age;
    private Integer experiense;


}
