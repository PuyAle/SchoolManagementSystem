package DAO;

import Entity.domain.Course;
import java.util.List;

public interface DAOCourse {

    Course createCourse(String name, int points);

    void addEducation(long courseId, long educationId);

    Course getCourse(Long courseId);

    List<Course> getCourseByName(String name);

    List<Course> getAllCourses();

    void removeCourse(long courseId);
}
