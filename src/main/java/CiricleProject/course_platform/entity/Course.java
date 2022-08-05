package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(generator = "course_seq")
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq_id",allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column(name = "course_ame")
    private String courseName;

    @Column(name = "mentor_id")
    private Integer mentorId;

    @Column(name = "course_prise")
    private Double coursePrise;

    private Integer during;

    private String status;
}
