package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.domain.Laporan;
import com.rizki.mufrizal.pelayanan.labti.repository.LaporanRepository;
import com.rizki.mufrizal.pelayanan.labti.service.LaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "laporan")
public class LaporanServiceImpl implements LaporanService {

    @Autowired
    private LaporanRepository laporanRepository;

    @CacheEvict(allEntries = true, key = "#laporan")
    @Transactional
    @Override
    public void simpanLaporan(Laporan laporan) {
        laporanRepository.save(laporan);
    }

    @CacheEvict(allEntries = true, key = "#laporan")
    @Transactional
    @Override
    public void ubahLaporan(Laporan laporan) {
        laporanRepository.save(laporan);
    }

    @CacheEvict(allEntries = true, key = "#idLaporan")
    @Transactional
    @Override
    public void hapusLaporan(String idLaporan) {
        laporanRepository.delete(idLaporan);
    }

    @Cacheable
    @Override
    public Laporan getLaporan(String idLaporan) {
        return laporanRepository.findOne(idLaporan);
    }

    @Cacheable
    @Override
    public Iterable<Laporan> getLaporans() {
        return laporanRepository.findAll();
    }

    @Cacheable
    @Override
    public Long countByNpmAndPraktikumIdPraktikum(String npm, String idPraktikum) {
        return laporanRepository.countByNpmAndPraktikumIdPraktikum(npm, idPraktikum);
    }

}
