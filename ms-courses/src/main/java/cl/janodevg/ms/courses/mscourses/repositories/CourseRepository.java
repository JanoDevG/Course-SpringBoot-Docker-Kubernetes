package cl.janodevg.ms.courses.mscourses.repositories;

import cl.janodevg.ms.courses.mscourses.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
