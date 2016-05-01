package com.rizki.mufrizal.pelayanan.labti.configuration;

import com.rizki.mufrizal.pelayanan.labti.PelayananLabTiApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 8:43:01 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.configuration
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PelayananLabTiApplication.class);
    }

}
