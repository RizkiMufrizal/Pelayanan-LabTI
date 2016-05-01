package com.rizki.mufrizal.pelayanan.labti.service.impl;

import com.rizki.mufrizal.pelayanan.labti.domain.UserRole;
import com.rizki.mufrizal.pelayanan.labti.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 9:11:37 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.service.impl
 *
 */
@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.rizki.mufrizal.pelayanan.labti.domain.User user = userRepository.loginUser(email);

        if (user != null) {
            List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());
            return buildUserForAuthentication(user, authorities);
        }

        return null;
    }

    private User buildUserForAuthentication(com.rizki.mufrizal.pelayanan.labti.domain.User user, List<GrantedAuthority> grantedAuthorities) {
        return new User(user.getEmail(), user.getPassword(), user.getEnable(), true, true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        userRoles.stream().forEach((userRole) -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        });

        return new ArrayList<>(grantedAuthorities);
    }

}
