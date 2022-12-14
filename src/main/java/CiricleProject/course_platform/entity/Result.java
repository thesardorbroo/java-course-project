package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(generator = "result_seq")
    @SequenceGenerator(name = "result_seq", sequenceName = "result_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

//    @Column(name = "student_id")
    @ManyToOne
    private Student student;

//    @Column(name = "lesson_id")
//    @OneToOne(mappedBy = "")
//    private Lesson lesson;

    private Boolean status;
}
