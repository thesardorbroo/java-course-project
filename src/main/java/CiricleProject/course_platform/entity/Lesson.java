package CiricleProject.course_platform.entity;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(generator = "lesson_seq")
    @SequenceGenerator(name = "lesson_seq", sequenceName = "lesson_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name="lesson_name")
    private String lessonName;

//    @Column(name="course_id")
    @ManyToOne
    private Course course;

    @Column(name="lesson_length")
    private String lessonLength;

    @Column(name="video_address")
    private  String videoAddress;

    @OneToMany(mappedBy = "lesson")
    private List<HomeWork> homeWork;

//    @OneToOne
//    private Result result;
}
