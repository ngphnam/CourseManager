package jpa03.Services;

import jpa03.Models.Course;

import java.util.Date;

public interface ICourseServices {
    public Course addDateCourse(int courseId, Date startDate, Date endDate);
    public String calculateRevenue();
}
