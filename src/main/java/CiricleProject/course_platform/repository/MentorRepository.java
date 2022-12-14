package CiricleProject.course_platform.repository;

import CiricleProject.course_platform.dto.MentorDto;
import CiricleProject.course_platform.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor,Integer> {
    Boolean existsByKey(String key);

}
