package CiricleProject.course_platform.repository;

import CiricleProject.course_platform.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    boolean existsByCourseName(String courseName);
}
