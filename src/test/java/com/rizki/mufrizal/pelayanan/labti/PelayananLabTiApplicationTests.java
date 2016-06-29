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
package com.rizki.mufrizal.pelayanan.labti;

import com.rizki.mufrizal.pelayanan.labti.service.impl.LaporanServiceImplTest;
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
    UserServiceImplTest.class,
    LaporanServiceImplTest.class
})
public class PelayananLabTiApplicationTests {

}
