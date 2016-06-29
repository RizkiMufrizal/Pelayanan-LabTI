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

import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;
import com.rizki.mufrizal.pelayanan.labti.repository.PraktikumRepository;
import com.rizki.mufrizal.pelayanan.labti.service.PraktikumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "praktikum")
public class PraktikumServiceImpl implements PraktikumService {

    @Autowired
    private PraktikumRepository praktikumRepository;

    @CacheEvict(allEntries = true, key = "#praktikum")
    @Transactional
    @Override
    public void simpanPraktikum(Praktikum praktikum) {
        praktikumRepository.save(praktikum);
    }

    @CacheEvict(allEntries = true, key = "#praktikum")
    @Transactional
    @Override
    public void ubahPraktikum(Praktikum praktikum) {
        praktikumRepository.save(praktikum);
    }

    @CacheEvict(allEntries = true, key = "#idPraktikum")
    @Transactional
    @Override
    public void hapusPraktikum(String idPraktikum) {
        praktikumRepository.delete(idPraktikum);
    }

    @Cacheable
    @Override
    public Praktikum getPraktikum(String idPraktikum) {
        return praktikumRepository.findOne(idPraktikum);
    }

    @Cacheable
    @Override
    public Iterable<Praktikum> getPraktikums() {
        return praktikumRepository.findAll();
    }
}
