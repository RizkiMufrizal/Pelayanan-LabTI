package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.domain.User;
import com.rizki.mufrizal.pelayanan.labti.domain.UserRole;
import com.rizki.mufrizal.pelayanan.labti.repository.UserRepository;
import com.rizki.mufrizal.pelayanan.labti.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 22, 2016
 * @Time 8:30:47 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service.impl
 *
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String username) {
        return userRepository.findOne(username);
    }

    @Transactional
    @Override
    public void simpanUser(User user) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_ADMIN");
        userRole.setUser(user);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);

        user.setUserRoles(userRoles);
        user.setEnable(Boolean.TRUE);

        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(String username) {
        userRepository.delete(username);
    }

    @Override
    public Iterable<User> users() {
        return userRepository.findAll();
    }

}
