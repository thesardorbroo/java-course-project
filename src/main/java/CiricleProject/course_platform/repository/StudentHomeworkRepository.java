package CiricleProject.course_platform.repository;

import CiricleProject.course_platform.entity.StudentHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentHomeworkRepository extends JpaRepository<StudentHomework,Integer> {

}
