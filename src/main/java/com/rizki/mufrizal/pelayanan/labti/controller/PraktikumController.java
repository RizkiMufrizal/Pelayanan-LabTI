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
package com.rizki.mufrizal.pelayanan.labti.controller;

import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;
import com.rizki.mufrizal.pelayanan.labti.service.PraktikumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since May 1, 2016
 * @Time 11:02:49 AM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.controller
 *
 */
@Controller
public class PraktikumController {

    @Autowired
    private PraktikumService praktikumService;

    @Secured(value = {"ROLE_ADMIN", "ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/Praktikum", method = RequestMethod.GET)
    public String ambilPraktikum(Model model) {
        model.addAttribute("praktikums", praktikumService.getPraktikums());
        return "PraktikumView";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/TambahPraktikum", method = RequestMethod.GET)
    public String tambahPraktikum(Model model) {
        model.addAttribute("praktikum", new Praktikum());
        return "PraktikumTambahView";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/SimpanPraktikum", method = RequestMethod.POST)
    public String simpanPraktikum(@ModelAttribute("praktikum") Praktikum praktikum) {
        praktikumService.simpanPraktikum(praktikum);
        return "redirect:/Praktikum";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/EditPraktikum/{idPraktikum}", method = RequestMethod.GET)
    public String editPraktikum(Model model, @PathVariable("idPraktikum") String idPraktikum) {
        model.addAttribute("praktikum", praktikumService.getPraktikum(idPraktikum));
        return "PraktikumEditView";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/UpdatePraktikum", method = RequestMethod.POST)
    public String updatePraktikum(@ModelAttribute("praktikum") Praktikum praktikum) {
        praktikumService.ubahPraktikum(praktikum);
        return "redirect:/Praktikum";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/HapusPraktikum/{idPraktikum}", method = RequestMethod.GET)
    public String hapusPraktikum(@PathVariable("idPraktikum") String idPraktikum) {
        praktikumService.hapusPraktikum(idPraktikum);
        return "redirect:/Praktikum";
    }

}
