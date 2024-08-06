package com.pawan.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.pawan.springboot.learn_jpa_and_hibernate.course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERIES= """
            INSERT INTO course(id,name,author) VALUES (?,?,?)
            """;

    private String DELETE_QUERIES= """
            DELETE FROM COURSE WHERE id = ?
            """;

    private String SELECT_QUERIES= """
            SELECT * FROM COURSE WHERE id = ?
            """;

    public void insertCourse(Course course){
        jdbcTemplate.update(INSERT_QUERIES,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteCourseByID(long id){
        jdbcTemplate.update(DELETE_QUERIES,id);
    }

    public Course getCourseByID(long id){
        //Result => Bean => BeanRowmapper
        return jdbcTemplate.queryForObject(SELECT_QUERIES,new BeanPropertyRowMapper<>(Course.class),id);
    }
}
