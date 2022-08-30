package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "course_id")
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

//    @Column(name = "student_id")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "is_paid")
    private Boolean isPaid;

}
