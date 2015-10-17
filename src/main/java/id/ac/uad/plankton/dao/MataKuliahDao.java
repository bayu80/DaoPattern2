package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.MataKuliah;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kipli on 14/10/15.
 */
public interface MataKuliahDao {

    void insert(MataKuliah mataKuliah) throws SQLException;

    void update(MataKuliah updatedMataKuliah) throws SQLException;

    void delete(int id) throws SQLException;

    List<MataKuliah> findAll();

    MataKuliah findById(int id);

    List<MataKuliah> findByNameLike(String name);
}
