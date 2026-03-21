package com.hospital.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hospital.dbms.models.User;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveUser(User user) {
        String sql = "INSERT INTO users(name) VALUES (?)";
        jdbcTemplate.update(sql, user.getName());
    }

    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setName(rs.getString("name"));
        return user;
    };

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }
}