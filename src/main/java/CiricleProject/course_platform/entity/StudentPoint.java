package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "student_point")
@NoArgsConstructor
@AllArgsConstructor
public class StudentPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "student_id")
    @OneToOne
    private Student student;

//    @Column(name = "lesson_id")
    @OneToOne
    private Lesson lesson;

    @Column(name = "point")
    private Integer point;
}
