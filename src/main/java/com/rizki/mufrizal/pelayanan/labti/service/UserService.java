package com.rizki.mufrizal.pelayanan.labti.service;

import com.rizki.mufrizal.pelayanan.labti.domain.User;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 22, 2016
 * @Time 8:30:20 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service
 *
 */
public interface UserService {

    User getUser(String username);

    void simpanUser(User user);

    void deleteUser(String username);

    Iterable<User> users();

}
