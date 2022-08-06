package CiricleProject.course_platform.repository;

import CiricleProject.course_platform.entity.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeWorkRepository extends JpaRepository<HomeWork,Integer> {

}

