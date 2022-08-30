package CiricleProject.course_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelegramGroup {
    @Id
    @SequenceGenerator(name = "Telegram_seq")
    @SequenceGenerator(name = "Telegram_seq",sequenceName = "Telegrm_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "group_name")
    private String groupName;

//    @Column(name = "course_id")
    @OneToOne
    private Course course;

    @Column(name = "course_link")
    private String courseLink;


}
