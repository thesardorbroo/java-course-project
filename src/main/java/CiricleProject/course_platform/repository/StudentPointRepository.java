package CiricleProject.course_platform.repository;

import CiricleProject.course_platform.entity.StudentPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPointRepository extends JpaRepository<StudentPoint, Integer> {
}
