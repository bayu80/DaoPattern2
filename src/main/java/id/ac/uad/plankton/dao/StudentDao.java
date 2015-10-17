package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kipli on 13/10/15.
 */
public interface StudentDao {
    void insert(Student student) throws SQLException;

    void update(Student updatedStudent) throws SQLException;

    void delete(int id) throws SQLException;

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByNameLike(String name);

}
