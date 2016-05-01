package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.domain.Laporan;
import com.rizki.mufrizal.pelayanan.labti.repository.LaporanRepository;
import com.rizki.mufrizal.pelayanan.labti.service.LaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 9:41:55 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class LaporanServiceImpl implements LaporanService {

    @Autowired
    private LaporanRepository laporanRepository;

    @Transactional
    @Override
    public void simpanLaporan(Laporan laporan) {
        laporanRepository.save(laporan);
    }

    @Transactional
    @Override
    public void ubahLaporan(Laporan laporan) {
        laporanRepository.save(laporan);
    }

    @Transactional
    @Override
    public void hapusLaporan(String idLaporan) {
        laporanRepository.delete(idLaporan);
    }

    @Override
    public Laporan getLaporan(String idLaporan) {
        return laporanRepository.findOne(idLaporan);
    }

    @Override
    public Iterable<Laporan> getLaporans() {
        return laporanRepository.findAll();
    }

}
