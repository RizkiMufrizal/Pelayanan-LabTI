package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.PelayananLabTiApplication;
import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;
import com.rizki.mufrizal.pelayanan.labti.service.PraktikumService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @Time 8:30:57 PM
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
            scripts = "/data/InsertPraktikum.sql"
    ),
    @Sql(
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            scripts = "/data/DeletePraktikum.sql"
    )
})
public class PraktikumServiceImplTest {

    @Autowired
    private PraktikumService praktikumService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSimpanPraktikum() throws SQLException {
        Praktikum praktikum = new Praktikum();
        praktikum.setNamaPraktikum("Algoritma Dan Pemrograman 2 A");
        praktikum.setBatasJumlahTidakMasuk(2);
        praktikum.setJumlahPertemuan(7);

        praktikumService.simpanPraktikum(praktikum);

        String sql = "select count(*) as jumlah from tb_praktikum where nama_praktikum = 'Algoritma Dan Pemrograman 2 A'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            Long jumlahRow = resultSet.getLong("jumlah");
            Assert.assertEquals(1L, jumlahRow.longValue());
        }

    }

    @Test
    public void testUbahPraktikum() throws SQLException {
        Praktikum praktikum = praktikumService.getPraktikum("1");
        Assert.assertNotNull(praktikum);

        praktikum.setJumlahPertemuan(4);
        praktikum.setBatasJumlahTidakMasuk(1);

        praktikumService.ubahPraktikum(praktikum);

        String sql = "select * from tb_praktikum where id_praktikum = '1'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            int jumlahPertemuan = resultSet.getInt("jumlah_pertemuan");
            int batasJumlahTidakMasuk = resultSet.getInt("batas_jumlah_tidak_masuk");
            Assert.assertEquals(4, jumlahPertemuan);
            Assert.assertEquals(1, batasJumlahTidakMasuk);
        }
    }

    @Test
    public void testHapusPraktikum() throws SQLException {
        Praktikum praktikum = praktikumService.getPraktikum("1");
        Assert.assertNotNull(praktikum);

        praktikumService.hapusPraktikum(praktikum.getIdPraktikum());

        String sql = "select * from tb_praktikum where id_praktikum = '1'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertFalse(resultSet.next());
        }
    }

    @Test
    public void testGetPraktikum() throws SQLException {
        Praktikum praktikum = praktikumService.getPraktikum("2");
        Assert.assertNotNull(praktikum);

        String sql = "select * from tb_praktikum where id_praktikum = '2'";

        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Assert.assertTrue(resultSet.next());

            int jumlahPertemuan = resultSet.getInt("jumlah_pertemuan");
            int praktikumJumlahPertemuan = praktikum.getJumlahPertemuan();

            Assert.assertEquals(jumlahPertemuan, praktikumJumlahPertemuan);
        }
    }

    @Test
    public void testGetPraktikums() throws SQLException {
        Iterable<Praktikum> praktikums = praktikumService.getPraktikums();
        Assert.assertNotNull(praktikums);
    }

}
