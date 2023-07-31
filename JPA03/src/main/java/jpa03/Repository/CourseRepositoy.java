package jpa03.Repository;

import jpa03.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositoy extends JpaRepository<Course, Integer> {
}
