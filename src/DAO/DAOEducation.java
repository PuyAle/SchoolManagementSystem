package DAO;

import Entity.domain.Education;
import java.util.List;

public interface DAOEducation {

    Education createEducation(String name, int points);

    void addCourse(long educationId, long courseId);

    Education getEducation(Long educationId);

    List<Education> getEducationByName(String name);

    List<Education> getAllEducations();

    void removeEducation(long educationId);
}
