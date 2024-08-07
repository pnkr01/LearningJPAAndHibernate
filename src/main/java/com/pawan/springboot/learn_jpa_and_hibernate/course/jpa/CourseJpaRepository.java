package com.pawan.springboot.learn_jpa_and_hibernate.course.jpa;

import com.pawan.springboot.learn_jpa_and_hibernate.course.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertCourse(Course course){
        entityManager.merge(course);
    }

    public Course getCourseById(long id){
        return entityManager.find(Course.class, id);
    }

    public void   deleteCourseById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
