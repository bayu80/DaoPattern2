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
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MataKuliah (KodeKuliah,NamaKuliah,Sks) VALUES (?,?,?)");
        preparedStatement.setInt(1, mataKuliah.getKodeKuliah());
        preparedStatement.setString(2, mataKuliah.getNamaKuliah());
        preparedStatement.setInt(3, mataKuliah.getSks());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(MataKuliah updatedMataKuliah) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MataKuliah SET NamaKuliah=? WHERE KodeKuliah=?");
        preparedStatement.setString(1, updatedMataKuliah.getNamaKuliah());
        preparedStatement.setInt(2, updatedMataKuliah.getKodeKuliah());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {


        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Matakuliah WHERE KodeKuliah=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<MataKuliah> findAll() {


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT KodeKuliah, NamaKuliah, Sks FROM MataKuliah");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<MataKuliah>mataKuliahList = new ArrayList<>();
            while(resultSet.next()){
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setKodeKuliah(resultSet.getInt("kode_kul"));
                mataKuliah.setNamaKuliah(resultSet.getString("nama_kul"));
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  NamaKuliah, Sks FROM Matakuliah WHERE KodeKuliah=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mataKuliah.setNamaKuliah(resultSet.getString("nama_kul"));
                mataKuliah.setSks(resultSet.getInt("sks"));
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
