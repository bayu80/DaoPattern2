package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.MataKuliahDao;
import id.ac.uad.plankton.model.MataKuliah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kipli on 14/10/15.
 */
public class MataKuliahDaoImpl implements MataKuliahDao {

    private final Connection connection;

    public MataKuliahDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insert(MataKuliah mataKuliah) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MataKuliah (Kode,Nama,Sks) VALUES (?,?,?)");
        preparedStatement.setInt(1, mataKuliah.getKode());
        preparedStatement.setString(2, mataKuliah.getNama());
        preparedStatement.setInt(3, mataKuliah.getSks());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(MataKuliah updatedMataKuliah) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MataKuliah SET Nama=? WHERE Kode=?");
        preparedStatement.setString(1, updatedMataKuliah.getNama());
        preparedStatement.setInt(2, updatedMataKuliah.getKode());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {


        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Matakuliah WHERE Kode=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<MataKuliah> findAll() {


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Kode, Nama, Sks FROM MataKuliah");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<MataKuliah>mataKuliahList = new ArrayList<>();
            while(resultSet.next()){
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setKode(resultSet.getInt("kode"));
                mataKuliah.setNama(resultSet.getString("nama"));
                mataKuliah.setSks(resultSet.getInt("sks"));

                mataKuliahList.add(mataKuliah);

            }
            return mataKuliahList;


        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();

        }

    }

    @Override
    public MataKuliah findById(int id) {

        MataKuliah mataKuliah = new MataKuliah();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  Nama, Sks FROM MataKuliah WHERE mata_kuliah_kode=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mataKuliah.setNama(resultSet.getString("Nama"));
                // mataKuliah.setKode(resultSet.getInt("mata_kuliah_kode"));
                mataKuliah.setSks(resultSet.getInt("Sks"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mataKuliah;
    }

    @Override
    public List<MataKuliah> findByNameLike(String name) {
        return null;
    }
}
