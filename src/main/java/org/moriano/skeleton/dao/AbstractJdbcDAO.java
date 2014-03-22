package org.moriano.skeleton.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 13/09/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractJdbcDAO {

    @Autowired
    private DataSource dataSource;

    protected JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
