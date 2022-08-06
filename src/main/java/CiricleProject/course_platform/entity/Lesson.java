package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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

    @Column(name="course_id")
    private Integer courseId;

    @Column(name="lesson_length")
    private String lessonLength;

    @Column(name="video_address")
    private  String videoAddress;
}
