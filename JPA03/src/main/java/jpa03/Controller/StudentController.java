package jpa03.Controller;

import com.google.gson.Gson;
import jpa03.Models.Course;
import jpa03.Models.Student;
import jpa03.Services.CourseServices;
import jpa03.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "jpa03/student")
public class StudentController {
    @Autowired
    private CourseServices courseServices;

    @Autowired
    private StudentServices studentServices;

    @RequestMapping(value = "remakestudent", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student remakeStudent(@RequestBody String studentRemake) {
        Gson gson = new Gson();
        Student student = gson.fromJson(studentRemake, Student.class);
        return studentServices.remakeStudent(student);
    }
}
