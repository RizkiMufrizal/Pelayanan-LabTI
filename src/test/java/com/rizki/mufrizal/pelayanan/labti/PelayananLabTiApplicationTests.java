package com.rizki.mufrizal.pelayanan.labti;

import com.rizki.mufrizal.pelayanan.labti.service.impl.PraktikumServiceImplTest;
import com.rizki.mufrizal.pelayanan.labti.service.impl.UserServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 29, 2016
 * @Time 7:53:53 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti
 *
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
    PraktikumServiceImplTest.class,
    UserServiceImplTest.class
})
public class PelayananLabTiApplicationTests {

}
