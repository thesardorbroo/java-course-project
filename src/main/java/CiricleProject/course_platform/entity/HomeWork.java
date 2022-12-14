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

@Table(name = "Homework")
public class HomeWork {
    @Id
    @GeneratedValue(generator = "homework_seq")
    @SequenceGenerator(name = "homework_seq",sequenceName = "homeword_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "task_body")
    private String taskBody;

//    @Column(name = "lesson_id")
    @ManyToOne
    private Lesson lesson;

    @Column(name = "extra_task")
    private String extraTask;

    private Integer point;

    @OneToMany(mappedBy = "homeWork")
    private List<StudentHomework> studentHomework;


}
