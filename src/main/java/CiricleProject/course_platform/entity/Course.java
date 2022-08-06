package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "course_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "mentor_id")
    private Integer mentorId;

    @Column(name = "course_price")
    private Double coursePrice;

    private Boolean status;

    private Integer during;
}
