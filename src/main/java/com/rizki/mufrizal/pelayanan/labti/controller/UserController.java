package com.rizki.mufrizal.pelayanan.labti.controller;

import com.rizki.mufrizal.pelayanan.labti.domain.User;
import com.rizki.mufrizal.pelayanan.labti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 22, 2016
 * @Time 11:52:46 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package com.rizki.mufrizal.pelayanan.labti.controller
 *
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Secured(value = {"ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/User", method = RequestMethod.GET)
    public String ambilUser(Model model) {
        model.addAttribute("users", userService.users());
        return "UserView";
    }

    @Secured(value = {"ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/TambahUser", method = RequestMethod.GET)
    public String tambahUser(Model model) {
        model.addAttribute("user", new User());
        return "UserTambahView";
    }

    @Secured(value = {"ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/SimpanUser", method = RequestMethod.POST)
    public String simpanUser(@ModelAttribute("user") User user) {
        userService.simpanUser(user);
        return "redirect:/User";
    }

    @Secured(value = {"ROLE_ADMINISTRATOR"})
    @RequestMapping(value = "/HapusUser/{username}", method = RequestMethod.GET)
    public String hapusUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return "redirect:/User";
    }

}
