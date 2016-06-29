package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.PelayananLabTiApplication;
import com.rizki.mufrizal.pelayanan.labti.domain.User;
import com.rizki.mufrizal.pelayanan.labti.service.UserService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 29, 2016
 * @Time 8:31:10 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service.impl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {PelayananLabTiApplication.class})
@SqlGroup({
    @Sql(
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            scripts = "/data/InsertUser.sql"
    ),
    @Sql(
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            scripts = "/data/DeleteUser.sql"
    )
})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testGetUser() throws SQLException {
        User user = userService.getUser("rizki mufrizal");
        Assert.assertNotNull(user);

        String sql = "select * from tb_user where username = 'rizki mufrizal'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            String passwordHashJdbc = resultSet.getString("password");
            String passwordHashJpa = user.getPassword();

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Assert.assertTrue(bCryptPasswordEncoder.matches("mufrizal", passwordHashJdbc));
            Assert.assertTrue(bCryptPasswordEncoder.matches("mufrizal", passwordHashJpa));
        }
    }

    @Test
    public void testSimpanUser() throws SQLException {
        User user = new User();
        user.setUsername("mufrizal");
        user.setPassword("rizki");

        userService.simpanUser(user);

        String sql = "select * from tb_user where username = 'mufrizal'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            Assert.assertEquals(1L, resultSet.getRow());

            String passwordHashJdbc = resultSet.getString("password");

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Assert.assertTrue(bCryptPasswordEncoder.matches("rizki", passwordHashJdbc));
        }
    }

    @Test
    public void testDeleteUser() throws SQLException {
        User user = userService.getUser("admin");
        Assert.assertNotNull(user);

        userService.deleteUser(user.getUsername());

        String sql = "select * from tb_praktikum where id_praktikum = 'admin'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertFalse(resultSet.next());
        }
    }

    @Test
    public void testUsers() throws SQLException {
        Iterable<User> users = userService.users();
        Assert.assertNotNull(users);
    }

}
