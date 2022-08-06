package CiricleProject.course_platform.repository;

import CiricleProject.course_platform.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}

