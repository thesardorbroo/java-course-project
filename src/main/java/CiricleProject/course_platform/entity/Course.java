package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


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
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

//    @Column(name = "mentor_id")

    @Column(name = "course_price")
    private Double coursePrice;

    private Boolean status;

    private Integer during;

    @OneToMany(mappedBy = "course")
    private List<Orders> orders;

    @ManyToOne
    private Mentor mentor;

    @OneToOne(mappedBy = "course")
    private TelegramGroup telegramGroup;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

}
