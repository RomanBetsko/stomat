package com.ua.stomat.appservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnloginZoneController {

    @GetMapping("/")
    public String internationalIndex() {
        return "dantista/index";
    }

    @GetMapping("/login")
    public String loginView() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "security/403";
    }

    @GetMapping("/doctor")
    public String doctor() {
        return "dantista/doctor";
    }

    @GetMapping("/about")
    public String about() {
        return "dantista/about";
    }


    @GetMapping("/department")
    public String department() {
        return "dantista/department";
    }

    @GetMapping("/therapeutic")
    public String therapeutic() {
        return "dantista/therapeutic";
    }

    @GetMapping("/pediatric")
    public String pediatric() {
        return "dantista/pediatric";
    }

    @GetMapping("/surgery")
    public String surgery (){
        return "dantista/surgery";
    }

    @GetMapping("/bleaching")
    public String bleaching (){
        return "dantista/bleaching";
    }

    @GetMapping("/orthodontics")
    public String orthodontics (){
        return "dantista/orthodontics";
    }

    @GetMapping("/prosthesis")
    public String prosthesis (){
        return "dantista/prosthesis";
    }

    @GetMapping("/laser")
    public String laser (){
        return "dantista/laser";
    }

    @GetMapping("/paradontology")
    public String paradontology (){
        return "dantista/paradontology";
    }

    @GetMapping("/primary")
    public String primary (){
        return "dantista/primary";
    }

    @GetMapping("/blog")
    public String blog() {
        return "dantista/blog";
    }

    @GetMapping("/contact")
    public String contact() {
        return "dantista/contact";
    }
}
