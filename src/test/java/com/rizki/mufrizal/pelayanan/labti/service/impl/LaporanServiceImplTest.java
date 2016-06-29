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
package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.PelayananLabTiApplication;
import com.rizki.mufrizal.pelayanan.labti.domain.Laporan;
import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;
import com.rizki.mufrizal.pelayanan.labti.domain.User;
import com.rizki.mufrizal.pelayanan.labti.service.LaporanService;
import com.rizki.mufrizal.pelayanan.labti.service.PraktikumService;
import com.rizki.mufrizal.pelayanan.labti.service.UserService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 29, 2016
 * @Time 8:30:36 PM
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
            scripts = "/data/InsertLaporan.sql"
    ),
    @Sql(
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            scripts = "/data/DeleteLaporan.sql"
    )
})
public class LaporanServiceImplTest {

    @Autowired
    private LaporanService laporanService;

    @Autowired
    private UserService userService;

    @Autowired
    private PraktikumService praktikumService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSimpanLaporan() throws SQLException {
        Praktikum praktikum = praktikumService.getPraktikum("2");
        User user = userService.getUser("admin");

        Laporan laporan = new Laporan();
        laporan.setKelas("4IA04");
        laporan.setKeterangan("izin");
        laporan.setNama("mufrizal");
        laporan.setNpm("12345678");
        laporan.setPertemuan(5);
        laporan.setTanggalLapor(new Date());
        laporan.setPraktikum(praktikum);
        laporan.setUser(user);

        laporanService.simpanLaporan(laporan);

        String sql = "select count(*) as jumlah from tb_laporan where npm = '12345678'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            Long jumlahRow = resultSet.getLong("jumlah");
            Assert.assertEquals(1L, jumlahRow.longValue());
        }
    }

    @Test
    public void testUbahLaporan() throws SQLException {
        Laporan laporan = laporanService.getLaporan("01");
        Assert.assertNotNull(laporan);

        laporan.setKelas("2IA04");
        laporan.setPertemuan(3);

        laporanService.ubahLaporan(laporan);

        String sql = "select * from tb_laporan where id_laporan = '01'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            String kelas = resultSet.getString("kelas");
            int pertemuan = resultSet.getInt("pertemuan");
            Assert.assertEquals("2IA04", kelas);
            Assert.assertEquals(3, pertemuan);
        }
    }

    @Test
    public void testHapusLaporan() throws SQLException {
        Laporan laporan = laporanService.getLaporan("01");
        Assert.assertNotNull(laporan);

        laporanService.hapusLaporan(laporan.getIdLaporan());

        String sql = "select * from tb_laporan where id_laporan = '01'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertFalse(resultSet.next());
        }
    }

    @Test
    public void testGetLaporan() throws SQLException {
        Laporan laporan = laporanService.getLaporan("02");
        Assert.assertNotNull(laporan);

        String sql = "select * from tb_laporan where id_laporan = '02'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            int pertemuanJdbc = resultSet.getInt("pertemuan");
            int pertemuanJpa = laporan.getPertemuan();

            Assert.assertEquals(pertemuanJdbc, pertemuanJpa);
        }
    }

    @Test
    public void testGetLaporans() throws SQLException {
        Iterable<Laporan> laporans = laporanService.getLaporans();
        Assert.assertNotNull(laporans);
    }

    @Test
    public void testCountByNpmAndPraktikumIdPraktikum() throws SQLException {
        Long banyakTidakIkutPraktikum1 = laporanService.countByNpmAndPraktikumIdPraktikum("58412085", "1");
        Long banyakTidakIkutPraktikum2 = laporanService.countByNpmAndPraktikumIdPraktikum("58412081", "4");

        Assert.assertEquals(2L, banyakTidakIkutPraktikum1.longValue());
        Assert.assertEquals(1L, banyakTidakIkutPraktikum2.longValue());
    }

}
