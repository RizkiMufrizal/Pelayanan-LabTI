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
