package com.nemirovsky.passportocrmvc.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "Hello Everybody on Main page!!";
    }
    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin!";
    }

    @RolesAllowed({ "ROLE_ADMIN", "ROLE_USER" })
    @GetMapping("/users")
    public String resources() {
        return "Hello User!";
    }

    @GetMapping("/about")
    public String about() {
        return "Hello Everybody on about page!";
    }

    @GetMapping("/news")
    public ModelAndView news() {
        ModelAndView mav = new ModelAndView("news");
        mav.addObject("newsTitle", "Thymeleaf news page!");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

}
