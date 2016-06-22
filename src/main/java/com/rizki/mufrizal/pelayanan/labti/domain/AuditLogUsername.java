package com.rizki.mufrizal.pelayanan.labti.domain;

import com.rizki.mufrizal.pelayanan.labti.configuration.AuditLogUsernameListener;
import java.io.Serializable;
import javax.persistence.Entity;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 22, 2016
 * @Time 9:56:55 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.domain
 *
 */
@Entity(name = "REVINFO")
@RevisionEntity(AuditLogUsernameListener.class)
public class AuditLogUsername extends DefaultRevisionEntity implements Serializable {

    private String username;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
