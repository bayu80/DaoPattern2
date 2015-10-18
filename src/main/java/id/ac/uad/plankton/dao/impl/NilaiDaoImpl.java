package id.ac.uad.plankton.dao.impl;

import com.sun.org.apache.bcel.internal.generic.Select;
import id.ac.uad.plankton.dao.NilaiDao;
import id.ac.uad.plankton.model.MataKuliah;
import id.ac.uad.plankton.model.Nilai;
import id.ac.uad.plankton.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kipli on 14/10/15.
 */
public class NilaiDaoImpl implements NilaiDao {

    private final Connection connection;

    public NilaiDaoImpl(Connection connection)
    {
        this.connection = connection;
    }



    @Override
    public void insert(Nilai nilai) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO nilai (nilai) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, nilai.getId());
        preparedStatement.setInt(2,nilai.getStudent().getId());
        preparedStatement.setInt(3,nilai.getMataKuliah().getKode());
        preparedStatement.setString(4, nilai.getNilai());

        preparedStatement.addBatch();

        preparedStatement.executeUpdate();

    }

    @Override
    public void update(Nilai updatedNilai) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE nilai SET nilai=? WHERE id=?");
        preparedStatement.setString(1, updatedNilai.getNilai());
        preparedStatement.setInt(2, updatedNilai.getId());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM nilai WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    @Override
    public List<Nilai> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT n.id,n.niiai,s.student_id as student_id, s.name as student_name, mk.Nama as matakuliah_name, mk.mata_kuliah_kode, mk.Sks FROM Nilai n \n" +
                    "INNER JOIN MataKuliah mk  ON mk.mata_kuliah_kode = n.mata_kuliah_kode\n" +
                    "INNER JOIN Student s ON s.student_id = n.student_id");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Nilai>nilaiList = new ArrayList<>();
            while (resultSet.next()){
                Student s = new Student();
                MataKuliah mk = new MataKuliah();
                s.setId(resultSet.getInt("student_id"));
                mk.setKode(resultSet.getInt("mata_Kuliah_Kode"));
                Nilai nilai = new Nilai();
                nilai.setStudent(s);
                nilai.setId(resultSet.getInt("id"));
                //nilai.setKodeKuliah(resultSet.getInt("kode_kul"));
                // nilai.setNamaKuliah(resultSet.getString("nama_kul"));
                nilai.setNilai(resultSet.getString("nilai"));

                nilaiList.add(nilai);
            }
            return nilaiList;
        } catch (SQLException e) {
            e.printStackTrace();

            return new ArrayList<>();
        }


    }

    @Override
    public List<Nilai> findByNameLike(String name) {
        return null;
    }


    @Override
    public Nilai findById(int id) {

        Nilai nilai=null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT niiai FROM Nilai WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nilai = new Nilai();
                //nilai.setKodeKuliah(resultSet.getInt("kode_kul"));
                //nilai.setNamaKuliah(resultSet.getString("nama_kul"));
                nilai.setNilai(resultSet.getString("niiai"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nilai;
    }
}
