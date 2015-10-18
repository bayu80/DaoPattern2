package id.ac.uad.plankton;

import id.ac.uad.plankton.dao.MataKuliahDao;
import id.ac.uad.plankton.dao.NilaiDao;
import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.dao.impl.MataKuliahDaoImpl;
import id.ac.uad.plankton.dao.impl.NilaiDaoImpl;
import id.ac.uad.plankton.dao.impl.StudentDaoImpl;
import id.ac.uad.plankton.db.DatabaseConnection;
import id.ac.uad.plankton.model.MataKuliah;
import id.ac.uad.plankton.model.Nilai;
import id.ac.uad.plankton.model.Student;

import javax.sound.midi.Soundbank;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kipli on 13/10/15.
 */
public class MainApplication {
    public static void main(String args[]){

        //Student kipli = new Student(5,"putra");


        try {
            StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());
            NilaiDao nilaiDao = new NilaiDaoImpl(DatabaseConnection.getInstance().getConnection());
            MataKuliahDao mataKuliahDao = new MataKuliahDaoImpl(DatabaseConnection.getInstance().getConnection());

            //studentDao.delete(1);
            //studentDao.update(kipli);

            //nilaiDao.insert(bayu);
// List<Nilai> nilaiDaoAll = nilaiDao.findAll();

            // Nilai b = nilaiDao.findById(6);
            //System.out.println("nilai     : " + b.getNilai());
// System.out.println("Nama    : " + s.getStudent());
// System.out.println("--------------------------");

            Student c = studentDao.findById(4);
            System.out.println("nama   :"+c.getName());

            MataKuliah mk = mataKuliahDao.findById(66);
            System.out.println("namaKul : "+mk.getNama());
            System.out.println("Sks        : "+mk.getSks());
            // System.out.println("kode     : "+mk.getKode());
            Nilai b = nilaiDao.findById(6);
            System.out.println("nilai     : " + b.getNilai());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}