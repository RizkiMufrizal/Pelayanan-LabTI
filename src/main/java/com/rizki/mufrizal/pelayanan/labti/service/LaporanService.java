package com.rizki.mufrizal.pelayanan.labti.service;

import com.rizki.mufrizal.pelayanan.labti.domain.Laporan;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 9:35:40 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service
 *
 */
public interface LaporanService {

    public void simpanLaporan(Laporan laporan);

    public void ubahLaporan(Laporan laporan);

    public void hapusLaporan(String idLaporan);

    public Laporan getLaporan(String idLaporan);

    public Iterable<Laporan> getLaporans();

    public Long countByNpmAndPraktikumIdPraktikum(String npm, String idPraktikum);

}
