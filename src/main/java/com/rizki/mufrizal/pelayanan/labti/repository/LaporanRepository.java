package com.rizki.mufrizal.pelayanan.labti.repository;

import com.rizki.mufrizal.pelayanan.labti.domain.Laporan;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 9:25:53 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.repository
 *
 */
public interface LaporanRepository extends PagingAndSortingRepository<Laporan, String> {
    
}
