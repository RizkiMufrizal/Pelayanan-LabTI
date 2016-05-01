package com.rizki.mufrizal.pelayanan.labti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 8:44:32 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti
 *
 */
@SpringBootApplication
@EnableCaching
public class PelayananLabTiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PelayananLabTiApplication.class, args);
    }
}
