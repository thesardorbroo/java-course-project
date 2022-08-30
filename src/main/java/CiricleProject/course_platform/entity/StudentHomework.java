package CiricleProject.course_platform.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_homework")
public class StudentHomework {

    @GeneratedValue(generator = "studentWork_seq")
    @SequenceGenerator(name = "studentWork_seq", sequenceName = "studentWork_id_seq", allocationSize = 1)
    @Column(name = "id")
    @Id
    private Integer id;

//    @Column(name = "student_id")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

//    @Column(name = "homework_id")
    @ManyToOne
    @JoinColumn(name = "homeWork_id")
    private HomeWork homeWork;

    private Boolean status;
}
