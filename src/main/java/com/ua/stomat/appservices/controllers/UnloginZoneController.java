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


    @GetMapping("/services")
    public String services() {
        return "dantista/services";
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

    @GetMapping("/caries")
    public String caries (){
        return "dantista/procedure/caries";
    }

    @GetMapping("/periodontitis")
    public String periodontitis (){
        return "dantista/procedure/periodontitis";
    }

    @GetMapping("/restavration")
    public String restavration (){
        return "dantista/procedure/restavration";
    }

    @GetMapping("/pulpitis")
    public String pulpitis (){
        return "dantista/procedure/pulpitis";
    }

    @GetMapping("/braces")
    public String braces (){
        return "dantista/procedure/braces";
    }

    @GetMapping("/eliners")
    public String eliners (){
        return "dantista/procedure/eliners";
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
