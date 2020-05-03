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
    public String surgery() {
        return "dantista/surgery";
    }

    @GetMapping("/bleaching")
    public String bleaching() {
        return "dantista/bleaching";
    }

    @GetMapping("/orthodontics")
    public String orthodontics() {
        return "dantista/orthodontics";
    }

    @GetMapping("/prosthesis")
    public String prosthesis() {
        return "dantista/prosthesis";
    }

    @GetMapping("/paradontology")
    public String paradontology() {
        return "dantista/paradontology";
    }

    @GetMapping("/primary")
    public String primary() {
        return "dantista/primary";
    }

    @GetMapping("/caries")
    public String caries() {
        return "dantista/procedure/caries";
    }

    @GetMapping("/periodontitis")
    public String periodontitis() {
        return "dantista/procedure/periodontitis";
    }

    @GetMapping("/restavration")
    public String restavration() {
        return "dantista/procedure/restavration";
    }

    @GetMapping("/pulpitis")
    public String pulpitis() {
        return "dantista/procedure/pulpitis";
    }

    @GetMapping("/braces")
    public String braces() {
        return "dantista/procedure/braces";
    }

    @GetMapping("/eliners")
    public String eliners() {
        return "dantista/procedure/eliners";
    }

    @GetMapping("/osteoplastics")
    public String osteoplastics() {
        return "dantista/procedure/osteoplastics";
    }

    @GetMapping("/sinuslifting")
    public String sinuslifting() {
        return "dantista/procedure/sinuslifting";
    }

    @GetMapping("/prosthesisimplant")
    public String prosthesisimplant() {
        return "dantista/procedure/prosthesisimplant";
    }

    @GetMapping("/ceramicrestoration")
    public String ceramicrestoration() {
        return "dantista/procedure/ceramicrestoration";
    }

    @GetMapping("/childrencaries")
    public String childrencaries() {
        return "dantista/procedure/childrencaries";
    }

    @GetMapping("/bridle")
    public String bridle() {
        return "dantista/procedure/bridle";
    }

    @GetMapping("/fissure")
    public String fissure() {
        return "dantista/procedure/fissure";
    }

    @GetMapping("/removableprosthetics")
    public String removableprosthetics() {
        return "dantista/procedure/removableprosthetics";
    }

    @GetMapping("/homebleaching")
    public String homebleaching() {
        return "dantista/procedure/homebleaching";
    }

    @GetMapping("/anesthesiainjection")
    public String anesthesiainjection() {
        return "dantista/procedure/anesthesiainjection";
    }

    @GetMapping("/philipszoom")
    public String philipszoom() {
        return "dantista/procedure/philipszoom";
    }

    @GetMapping("/xray")
    public String xray() {
        return "dantista/procedure/xray";
    }

    @GetMapping("/treatmentplan")
    public String treatmentplan() {
        return "dantista/procedure/treatmentplan";
    }

    @GetMapping("/curettage")
    public String curettage() {
        return "dantista/procedure/curettage";
    }

    @GetMapping("/periodontalmap")
    public String periodontalmap() {
        return "dantista/procedure/periodontalmap";
    }

    @GetMapping("/initialconsultation")
    public String initialconsultation() {
        return "dantista/procedure/initialconsultation";
    }

    @GetMapping("/orthodonticappliances")
    public String orthodonticappliances() {
        return "dantista/procedure/orthodonticappliances";
    }

    @GetMapping("/cofferdam")
    public String cofferdam() {
        return "dantista/procedure/cofferdam";
    }

    @GetMapping("/lazer")
    public String lazer() {
        return "dantista/lazer";
    }

    @GetMapping("/bugel")
    public String bugel() {
        return "dantista/procedure/bugel";
    }

    @GetMapping("/hygiene")
    public String hygiene() {
        return "dantista/procedure/hygiene";
    }

    @GetMapping("/removal")
    public String removal() {
        return "dantista/procedure/removal";
    }

    @GetMapping("/crowns")
    public String crowns() {
        return "dantista/procedure/crowns";
    }

    @GetMapping("/periodontics")
    public String periodontics() {
        return "dantista/periodontics";
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
