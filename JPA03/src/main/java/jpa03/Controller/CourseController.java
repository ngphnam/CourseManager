package jpa03.Controller;

import com.google.gson.Gson;
import jpa03.Models.Course;
import jpa03.Services.CourseServices;
import jpa03.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "jpa03/course")
public class CourseController {
    @Autowired
    private CourseServices courseServices;

    @Autowired
    private StudentServices studentServices;

    @RequestMapping(value = "adddatecourse", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course addDateCourse(@RequestBody String courseJson) {
        Gson gson = new Gson();
        Course course = gson.fromJson(courseJson, Course.class);
        return courseServices.addDateCourse(course.getId(), course.getStartDate(), course.getEndDate());
    }
    @RequestMapping(value = "calculaterevenue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculateRevenue() {
        return courseServices.calculateRevenue();
    }
}
