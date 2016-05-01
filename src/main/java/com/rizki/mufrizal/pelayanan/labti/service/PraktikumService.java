package com.rizki.mufrizal.pelayanan.labti.service;

import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 9:10:37 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service
 *
 */
public interface PraktikumService {

    public void simpanPraktikum(Praktikum praktikum);

    public void ubahPraktikum(Praktikum praktikum);

    public void hapusPraktikum(String idPraktikum);

    public Praktikum getPraktikum(String idPraktikum);

    public Iterable<Praktikum> getPraktikums();

}
