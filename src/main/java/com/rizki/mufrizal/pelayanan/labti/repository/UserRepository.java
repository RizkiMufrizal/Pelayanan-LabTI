package com.rizki.mufrizal.pelayanan.labti.repository;

import com.rizki.mufrizal.pelayanan.labti.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 9:08:06 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.repository
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    @Query("select u from User u left join fetch u.userRoles pd where u.email = :email")
    User loginUser(@Param("email") String email);

}
