package id.ac.uad.plankton;

import id.ac.uad.plankton.dao.impl.MataKuliahDaoImpl;
import id.ac.uad.plankton.db.DatabaseConnection;
import id.ac.uad.plankton.model.MataKuliah;

import java.sql.SQLException;

/**
 * Created by kipli on 13/10/15.
 */
public class MainApplication {
    public static void main(String args[]){

        //Student kipli = new Student(5,"putra");

        MataKuliah mezi = new MataKuliah(188,"kalku",9);

        try {
            MataKuliahDaoImpl mataKuliahDao = new MataKuliahDaoImpl(DatabaseConnection.getInstance().getConnection());
//studentDao.insert(kipli);
            //studentDao.delete(1);
            //studentDao.update(kipli);

            mataKuliahDao.insert(mezi);
 /*List<Student> studentList = studentDao.findAll();

 for (Student s : studentList) {
 System.out.println("Id      : " + s.getId());
 System.out.println("Nama    : " + s.getName());
 System.out.println("--------------------------");
 }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
