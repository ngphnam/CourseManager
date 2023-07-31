package jpa03.Services;

import jpa03.Models.Student;
import jpa03.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentServices implements IStudentServices{
    private StudentRepository studentRepository;


    @Autowired
    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentServices() {
    }

    @Override
    public Student remakeStudent(Student studentRemake) {
        Optional<Student> student = studentRepository.findById(studentRemake.getId());

        if(student.isEmpty()) return null;
        Student stRe = student.get();
        stRe.setFullname(studentRemake.getFullname());
        stRe.setDob(studentRemake.getDob());
        stRe.setHometown(studentRemake.getHometown());
        stRe.setAddress(studentRemake.getAddress());
        stRe.setPhoneNumber(studentRemake.getPhoneNumber());
        stRe.setCourseId(studentRemake.getCourseId());
        studentRepository.save(stRe);
        return stRe;
    }
}
