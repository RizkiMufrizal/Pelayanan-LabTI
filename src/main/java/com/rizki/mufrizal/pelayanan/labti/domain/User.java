package com.rizki.mufrizal.pelayanan.labti.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 8:56:59 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.domain
 *
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 150)
    private String password;
    
    @Column(name = "enable")
    private Boolean enable;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<UserRole> userRoles = new HashSet<>();

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enable
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * @return the userRoles
     */
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    /**
     * @param userRoles the userRoles to set
     */
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}
