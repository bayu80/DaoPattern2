package id.ac.uad.plankton.dao.impl;

/**
 * Created by kipli on 13/10/15.
 */
import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**.
 */
public class StudentDaoImpl implements StudentDao {
    private final Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Student (id,name) VALUES (?,?)");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());

        preparedStatement.executeUpdate();

    }

    @Override
    public void update(Student updatedStudent) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Student SET name=? WHERE id=?");
        preparedStatement.setString(1, updatedStudent.getName());
        preparedStatement.setInt(2, updatedStudent.getId());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Student WHERE id= ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    @Override
    public Student findById(int id) {

        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM Student WHERE student_id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                student.setName(resultSet.getString("name"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<Student> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name AS nama FROM Student");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("nama"));

                studentList.add(student);
            }

            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Student> findByNameLike(String name) {
        return null;
    }
}
