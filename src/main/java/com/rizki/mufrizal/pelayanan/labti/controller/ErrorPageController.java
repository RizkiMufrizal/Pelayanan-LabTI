package com.rizki.mufrizal.pelayanan.labti.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 22, 2016
 * @Time 10:12:50 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.controller
 *
 */
@Controller
public class ErrorPageController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String page404() {
        return "error/404";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public String page401() {
        return "error/401";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String page403() {
        return "error/403";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String page500() {
        return "error/500";
    }

}
