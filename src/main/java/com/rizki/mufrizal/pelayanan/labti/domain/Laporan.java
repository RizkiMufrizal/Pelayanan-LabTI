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
package com.rizki.mufrizal.pelayanan.labti.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 8:52:18 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.domain
 *
 */
@Entity
@Audited
@Table(name = "tb_laporan")
public class Laporan implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_laporan", length = 150)
    private String idLaporan;

    @Column(name = "npm", length = 8, nullable = false)
    private String npm;

    @Column(name = "nama", length = 50, nullable = false)
    private String nama;

    @Column(name = "kelas", length = 6, nullable = false)
    private String kelas;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-M-dd")
    @Column(name = "tanggal_lapor", nullable = false)
    private Date tanggalLapor;

    @Column(name = "pertemuan", nullable = false)
    private Integer pertemuan;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "keterangan", nullable = false)
    private String keterangan;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPraktikum", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Praktikum praktikum;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private User user;

    /**
     * @return the idLaporan
     */
    public String getIdLaporan() {
        return idLaporan;
    }

    /**
     * @param idLaporan the idLaporan to set
     */
    public void setIdLaporan(String idLaporan) {
        this.idLaporan = idLaporan;
    }

    /**
     * @return the npm
     */
    public String getNpm() {
        return npm;
    }

    /**
     * @param npm the npm to set
     */
    public void setNpm(String npm) {
        this.npm = npm;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    /**
     * @return the tanggalLapor
     */
    public Date getTanggalLapor() {
        return tanggalLapor;
    }

    /**
     * @param tanggalLapor the tanggalLapor to set
     */
    public void setTanggalLapor(Date tanggalLapor) {
        this.tanggalLapor = tanggalLapor;
    }

    /**
     * @return the pertemuan
     */
    public Integer getPertemuan() {
        return pertemuan;
    }

    /**
     * @param pertemuan the pertemuan to set
     */
    public void setPertemuan(Integer pertemuan) {
        this.pertemuan = pertemuan;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the praktikum
     */
    public Praktikum getPraktikum() {
        return praktikum;
    }

    /**
     * @param praktikum the praktikum to set
     */
    public void setPraktikum(Praktikum praktikum) {
        this.praktikum = praktikum;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
