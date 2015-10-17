
package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.Nilai;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kipli on 14/10/15.
 */
public interface NilaiDao {

    void insert(Nilai nilai) throws SQLException;

    void update(Nilai updatedNilai) throws SQLException;

    void delete(int id) throws SQLException;

    List<Nilai> findAll();

    Nilai findById(int id);

    List<Nilai> findByNameLike(String name);
}