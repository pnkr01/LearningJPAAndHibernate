package com.pawan.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.pawan.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.pawan.springboot.learn_jpa_and_hibernate.course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository courseJdbcRepository;

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insertCourse(new Course(1,"Spring Boot", "Spring Boot Course"));
        repository.insertCourse(new Course(2,"Spring MVC", "Spring MVC Course"));
        repository.insertCourse(new Course(3,"Spring JPA", "Spring JPA Course"));

        repository.deleteCourseById(1);

        System.out.println(repository.getCourseById(2));;
        System.out.println(repository.getCourseById(3));;
    }
}
