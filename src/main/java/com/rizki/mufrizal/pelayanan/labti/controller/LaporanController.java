package com.rizki.mufrizal.pelayanan.labti.controller;

import com.rizki.mufrizal.pelayanan.labti.domain.Laporan;
import com.rizki.mufrizal.pelayanan.labti.domain.Praktikum;
import com.rizki.mufrizal.pelayanan.labti.service.LaporanService;
import com.rizki.mufrizal.pelayanan.labti.service.PraktikumService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 30, 2016
 * @Time 9:52:07 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.controller
 *
 */
@Controller
public class LaporanController {

    @Autowired
    private LaporanService laporanService;

    @Autowired
    private PraktikumService praktikumService;

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/Laporan", method = RequestMethod.GET)
    public String ambilLaporan(Model model) {
        model.addAttribute("laporans", laporanService.getLaporans());
        return "LaporanView";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/TambahLaporan", method = RequestMethod.GET)
    public String tambahLaporan(Model model) {
        model.addAttribute("laporan", new Laporan());
        model.addAttribute("praktikums", praktikumService.getPraktikums());
        return "LaporanTambahView";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/SimpanLaporan", method = RequestMethod.POST)
    public String simpanLaporan(@ModelAttribute("laporan") @Valid Laporan laporan, BindingResult result) {

        Praktikum praktikum = praktikumService.getPraktikum(laporan.getPraktikum().getIdPraktikum());

        Long jumlahTidakMasuk = laporanService.countByNpmAndPraktikumIdPraktikum(laporan.getNpm(), praktikum.getIdPraktikum());

        if (jumlahTidakMasuk.intValue() + 1 > praktikum.getBatasJumlahTidakMasuk()) {
            return "redirect:/TambahLaporan?jumlahTidakMasukMelebihiBatas";
        }

        laporan.setPraktikum(praktikum);

        laporanService.simpanLaporan(laporan);
        return "redirect:/Laporan";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/EditLaporan/{idLaporan}", method = RequestMethod.GET)
    public String editLaporan(Model model, @PathVariable("idLaporan") String idLaporan) {
        model.addAttribute("laporan", laporanService.getLaporan(idLaporan));
        model.addAttribute("praktikums", praktikumService.getPraktikums());
        return "LaporanEditView";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/UpdateLaporan", method = RequestMethod.POST)
    public String updateLaporan(@ModelAttribute("laporan") Laporan laporan) {

        Praktikum praktikum = praktikumService.getPraktikum(laporan.getPraktikum().getIdPraktikum());
        laporan.setPraktikum(praktikum);

        laporanService.ubahLaporan(laporan);
        return "redirect:/Laporan";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/HapusLaporan/{idLaporan}", method = RequestMethod.GET)
    public String hapusLaporan(@PathVariable("idLaporan") String idLaporan) {
        laporanService.hapusLaporan(idLaporan);
        return "redirect:/Laporan";
    }

}
