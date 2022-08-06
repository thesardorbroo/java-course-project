package CiricleProject.course_platform.repository;

import CiricleProject.course_platform.entity.TelegramGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramGroupRepository extends JpaRepository<TelegramGroup,Integer> {
}
