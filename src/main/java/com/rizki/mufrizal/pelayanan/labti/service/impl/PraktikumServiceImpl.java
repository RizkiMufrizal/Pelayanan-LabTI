package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;
import com.rizki.mufrizal.pelayanan.labti.repository.PraktikumRepository;
import com.rizki.mufrizal.pelayanan.labti.service.PraktikumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 11:05:18 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class PraktikumServiceImpl implements PraktikumService {

    @Autowired
    private PraktikumRepository praktikumRepository;

    @Transactional
    @Override
    public void simpanPraktikum(Praktikum praktikum) {
        praktikumRepository.save(praktikum);
    }

    @Transactional
    @Override
    public void ubahPraktikum(Praktikum praktikum) {
        praktikumRepository.save(praktikum);
    }

    @Transactional
    @Override
    public void hapusPraktikum(Praktikum praktikum) {
        praktikumRepository.delete(praktikum);
    }

    @Override
    public Praktikum getPraktikum(String idPraktikum) {
        return praktikumRepository.findOne(idPraktikum);
    }

    @Override
    public Iterable<Praktikum> getPraktikums() {
        return praktikumRepository.findAll();
    }
}