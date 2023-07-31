package jpa03.Services;

import jpa03.Models.Course;
import jpa03.Models.Student;
import jpa03.Repository.CourseRepositoy;
import jpa03.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
@Component
public class CourseServices implements ICourseServices{
    private CourseRepositoy courseRepositoy;
    private StudentRepository studentRepository;

    @Autowired
    public CourseServices(CourseRepositoy courseRepositoy, StudentRepository studentRepository) {
        this.courseRepositoy = courseRepositoy;
        this.studentRepository = studentRepository;
    }



    @Override
    public Course addDateCourse(int courseId, Date startDate, Date endDate) {
        Optional<Course> course = courseRepositoy.findById(courseId);
        if (course.isEmpty()) {
            return null;
        }
        Course courseDate = course.get();
        try {
            courseDate.setStartDate(startDate);
            courseDate.setEndDate(endDate);
            courseRepositoy.save(courseDate);
            return courseDate;
        } catch (Exception e) {
            System.out.println(e);
        }
        return courseDate;
    }

    @Override
    public String calculateRevenue() {
        String value = null;
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            int revenue = 0;
            for (Course course : courseRepositoy.findAll()) {
                c.setTime(course.getStartDate());
                if (c.get(Calendar.MONTH) == i) {
                    for (Student student : studentRepository.findAll()) {
                        if (student.getCourse() == course) {
                            revenue += course.getTuition();
                        }
                    }
                }
            }
            value += "Month" + String.valueOf(i + 1) + ": " + String.valueOf(revenue) + "\n";
        }
        return value;
    }
}
