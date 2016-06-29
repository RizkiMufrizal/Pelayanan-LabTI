package com.rizki.mufrizal.pelayanan.labti.configuration;

import com.rizki.mufrizal.pelayanan.labti.domain.AuditLogUsername;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 22, 2016
 * @Time 9:59:31 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.configuration
 *
 */
public class AuditLogUsernameListener implements RevisionListener {

    @Override
    public void newRevision(Object object) {
        AuditLogUsername auditLogUsername = (AuditLogUsername) object;
        String username;

        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            username = SecurityContextHolder.getContext().getAuthentication().getName();
        } else {
            username = "test";
        }

        auditLogUsername.setUsername(username);
    }

}
