
package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.NilaiDao;
import id.ac.uad.plankton.model.Nilai;

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

    public NilaiDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Nilai nilai) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO nilai (id,kode_kul,nama_kul,nilai) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, nilai.getId());
        preparedStatement.setInt(2, nilai.getKodeKuliah());
        preparedStatement.setString(3, nilai.getNamaKuliah());
        preparedStatement.setString(4, nilai.getNilai());

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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,kode_kul,nama_kul,nilai FROM nilai");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Nilai>nilaiList = new ArrayList<>();
            while (resultSet.next()){
                Nilai nilai = new Nilai();
                nilai.setId(resultSet.getInt("id"));
                nilai.setKodeKuliah(resultSet.getInt("kode_kul"));
                nilai.setNamaKuliah(resultSet.getString("nama_kul"));
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
    public Nilai findById(int id) {

        Nilai nilai = new Nilai();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kode_kul, nama_kul, nilai FROM nilai WHERE id=?");preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nilai.setKodeKuliah(resultSet.getInt("kode_kul"));
                nilai.setNamaKuliah(resultSet.getString("nama_kul"));
                nilai.setNilai(resultSet.getString("nilai"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nilai;
    }

    @Override
    public List<Nilai> findByNameLike(String name) {
        return null;
    }
}