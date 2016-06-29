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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 8:47:53 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.domain
 *
 */
@Entity
@Audited
@Table(name = "tb_praktikum")
public class Praktikum implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_praktikum", length = 150)
    private String idPraktikum;

    @Column(name = "nama_praktikum", length = 50)
    private String namaPraktikum;

    @Column(name = "jumlah_pertemuan")
    private Integer jumlahPertemuan;

    @Column(name = "batas_jumlah_tidak_masuk")
    private Integer batasJumlahTidakMasuk;

    @JsonIgnore
    @OneToMany(mappedBy = "praktikum", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Laporan> laporans = new ArrayList<>();

    /**
     * @return the idPraktikum
     */
    public String getIdPraktikum() {
        return idPraktikum;
    }

    /**
     * @param idPraktikum the idPraktikum to set
     */
    public void setIdPraktikum(String idPraktikum) {
        this.idPraktikum = idPraktikum;
    }

    /**
     * @return the namaPraktikum
     */
    public String getNamaPraktikum() {
        return namaPraktikum;
    }

    /**
     * @param namaPraktikum the namaPraktikum to set
     */
    public void setNamaPraktikum(String namaPraktikum) {
        this.namaPraktikum = namaPraktikum;
    }

    /**
     * @return the jumlahPertemuan
     */
    public Integer getJumlahPertemuan() {
        return jumlahPertemuan;
    }

    /**
     * @param jumlahPertemuan the jumlahPertemuan to set
     */
    public void setJumlahPertemuan(Integer jumlahPertemuan) {
        this.jumlahPertemuan = jumlahPertemuan;
    }

    /**
     * @return the batasJumlahTidakMasuk
     */
    public Integer getBatasJumlahTidakMasuk() {
        return batasJumlahTidakMasuk;
    }

    /**
     * @param batasJumlahTidakMasuk the batasJumlahTidakMasuk to set
     */
    public void setBatasJumlahTidakMasuk(Integer batasJumlahTidakMasuk) {
        this.batasJumlahTidakMasuk = batasJumlahTidakMasuk;
    }

    /**
     * @return the laporans
     */
    public List<Laporan> getLaporans() {
        return laporans;
    }

    /**
     * @param laporans the laporans to set
     */
    public void setLaporans(List<Laporan> laporans) {
        this.laporans = laporans;
    }

}
