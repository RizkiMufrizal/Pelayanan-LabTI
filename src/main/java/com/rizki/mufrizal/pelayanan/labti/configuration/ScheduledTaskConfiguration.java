/**
 * Copyright (C) 2016 Rizki Mufrizal (https://rizkimufrizal.github.io/) (mufrizalrizki@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rizki.mufrizal.pelayanan.labti.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 28, 2016
 * @Time 11:52:10 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.configuration
 *
 */
@EnableScheduling
@Component
public class ScheduledTaskConfiguration {

    @Autowired
    private DataSource dataSource;

    private Connection connection;

    private PreparedStatement preparedStatementSelectUser;
    private PreparedStatement preparedStatementSelectUserRole;

    private PreparedStatement preparedStatementInsertUser;
    private PreparedStatement preparedStatementInsertUserRole;

    private final String selectTableUserSQL = "SELECT * FROM tb_user WHERE username = ?";
    private final String selectTableUserRoleSQL = "SELECT * FROM tb_user_role WHERE username = ?";

    private final String insertTableUserSQL = "INSERT INTO tb_user(username, password, enable) values(?, ?, ?)";
    private final String insertTableUserRoleSQL = "INSERT INTO tb_user_role(id_user_role, role, username) values(?, ?, ?)";

    @Scheduled(fixedRate = 3600000)
    public void insertDefaultUserAdministrator() throws SQLException {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        connection = dataSource.getConnection();

        preparedStatementSelectUser = connection.prepareStatement(selectTableUserSQL);
        preparedStatementSelectUser.setString(1, "administrator");
        ResultSet resultSetUser = preparedStatementSelectUser.executeQuery();

        preparedStatementSelectUserRole = connection.prepareStatement(selectTableUserRoleSQL);
        preparedStatementSelectUserRole.setString(1, "administrator");
        ResultSet resultSetUserRole = preparedStatementSelectUserRole.executeQuery();

        if (!resultSetUser.next() && !resultSetUserRole.next()) {
            preparedStatementInsertUser = connection.prepareStatement(insertTableUserSQL);
            preparedStatementInsertUser.setString(1, "administrator");
            preparedStatementInsertUser.setString(2, bCryptPasswordEncoder.encode("administratorlabti2016"));
            preparedStatementInsertUser.setBoolean(3, Boolean.TRUE);
            preparedStatementInsertUser.executeUpdate();

            preparedStatementInsertUserRole = connection.prepareStatement(insertTableUserRoleSQL);
            preparedStatementInsertUserRole.setString(1, UUID.randomUUID().toString());
            preparedStatementInsertUserRole.setString(2, "ROLE_ADMINISTRATOR");
            preparedStatementInsertUserRole.setString(3, "administrator");
            preparedStatementInsertUserRole.executeUpdate();

            preparedStatementInsertUser.close();
            preparedStatementInsertUserRole.close();
        }

        preparedStatementSelectUser.close();
        preparedStatementSelectUserRole.close();
        connection.close();

    }
}
