package org.moriano.skeleton.dao;

import org.moriano.skeleton.model.God;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 13/09/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class GodDAO extends AbstractJdbcDAO{

    private static final String SQL_GET_ALL = "SELECT * FROM gods";
    private static final String SQL_GET_BY_ID = "SELECT * FROM gods WHERE id = ?";
    private static final String SQL_GET_BY_AGE = "SELECT * FROM gods WHERE age = ?";
    private static final String SQL_GET_NAMES = "SELECT name FROM gods WHERE id = ?";
    private static final String SQL_SAVE = "INSERT INTO gods (age, name) VALUES (?, ?)";
    private static final String SQL_GET_BY_NAME = "SELECT * FROM gods WHERE name = ?";
    private static final String SQL_DELETE = "DELETE FROM gods WHERE id = ?";

    public List<God> getAll() {
        return this.jdbcTemplate.query(SQL_GET_ALL, new GodMapper());
    }

    /**
     * Returns ALWAYS a single god or fails
     * @param id
     * @return
     */
    public God getById(int id) {
        return this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new GodMapper());
    }

    /**
     * Get all the gods matching a given age, 0 to n results expected
     * @param age
     * @return
     */
    public List<God> getByAge(int age) {
        return this.jdbcTemplate.query(SQL_GET_BY_AGE, new Object[]{age}, new GodMapper());
    }

    /**
     * Get all the gods matching a given name, 0 to n results expected
     * @param name
     * @return
     */
    public List<God> getByName(String name) {
        return this.jdbcTemplate.query(SQL_GET_BY_NAME, new Object[]{name}, new GodMapper());
    }

    /**
     * Get the name of all the gods with a given age
     * @param age
     * @return
     */
    public List<String> getNames(int age) {
        return this.jdbcTemplate.queryForList(SQL_GET_NAMES, new Object[]{age}, String.class);
    }

    /**
     * Creates a new god, returns its id
     * @param age
     * @param name
     * @return
     */
    public void save(int age, String name) {
        this.jdbcTemplate.update(SQL_SAVE, age, name);

    }

    public int delete(int id) {
        return this.jdbcTemplate.update(SQL_DELETE, new Object[]{id});
    }

    /**
     * Simple class for mapping results into Gods
     */
    private static final class GodMapper implements RowMapper<God> {
        @Override
        public God mapRow(ResultSet resultSet, int i) throws SQLException {
            return new God(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"));
        }
    }




}
