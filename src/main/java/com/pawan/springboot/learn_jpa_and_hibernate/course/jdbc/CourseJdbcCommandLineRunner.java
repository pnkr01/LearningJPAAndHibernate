package com.pawan.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.pawan.springboot.learn_jpa_and_hibernate.course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insertCourse(new Course(1,"Spring Boot", "Spring Boot Course"));
        courseJdbcRepository.insertCourse(new Course(2,"Spring MVC", "Spring MVC Course"));
        courseJdbcRepository.insertCourse(new Course(3,"Spring JPA", "Spring JPA Course"));

        courseJdbcRepository.deleteCourseByID(1);

        System.out.println(courseJdbcRepository.getCourseByID(2));;
        System.out.println(courseJdbcRepository.getCourseByID(3));;
    }
}
