package com.rizki.mufrizal.pelayanan.labti.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 12:41:53 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.controller
 *
 */
@Controller
public class PageController {

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "IndexView";
    }

}
