package com.ua.stomat.appservices.controllers;

import com.redfin.sitemapgenerator.WebSitemapGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.BufferedReader;

@Controller
public class UnloginZoneController {

    private Path sitemapDirectory;

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

//    @GetMapping("/doctor")
//    public String doctor() {
//        return "dantista/doctor";
//    }

    @GetMapping("/about")
    public String about() {
        return "dantista/about";
    }

    //Blog items
    @GetMapping("/blog")
    public String blog() {
        return "dantista/blog";
    }

//    @GetMapping("/blog2")
//    public String blog2() {
//        return "dantista/blog2";
//    }
//
//    @GetMapping("/blog3")
//    public String blog3() {
//        return "dantista/blog3";
//    }
//
//    @GetMapping("/blog4")
//    public String blog4() {
//        return "dantista/blog4";
//    }

    //Contact
    @GetMapping("/contact")
    public String contact() {
        return "dantista/contact";
    }


    @GetMapping("/services")
    public String services() {
        return "dantista/services";
    }

    // List of services 9 pieces

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

    @GetMapping("/lazer")
    public String lazer() {
        return "dantista/lazer";
    }

    @GetMapping("/primary")
    public String primary() {
        return "dantista/primary";
    }

    @GetMapping("/periodontics")
    public String periodontics() {
        return "dantista/periodontics";
    }

    // List of procedures

    @GetMapping("/philipszoom")
    public String philipszoom() {
        return "dantista/procedure/philipszoom";
    }

    @GetMapping("/hygiene")
    public String hygiene() {
        return "dantista/procedure/hygiene";
    }

    @GetMapping("/removal")
    public String removal() {
        return "dantista/procedure/removal";
    }

//    @GetMapping("/caries")
//    public String caries() {
//        return "dantista/procedure/caries";
//    }
//
//    @GetMapping("/periodontitis")
//    public String periodontitis() {
//        return "dantista/procedure/periodontitis";
//    }
//    @GetMapping("/restavration")
//    public String restavration() {
//        return "dantista/procedure/restavration";
//    }
//
//    @GetMapping("/pulpitis")
//    public String pulpitis() {
//        return "dantista/procedure/pulpitis";
//    }
//
//    @GetMapping("/braces")
//    public String braces() {
//        return "dantista/procedure/braces";
//    }
//
//    @GetMapping("/eliners")
//    public String eliners() {
//        return "dantista/procedure/eliners";
//    }
//
//    @GetMapping("/osteoplastics")
//    public String osteoplastics() {
//        return "dantista/procedure/osteoplastics";
//    }
//    @GetMapping("/sinuslifting")
//    public String sinuslifting() {
//        return "dantista/procedure/sinuslifting";
//    }
//
//    @GetMapping("/prosthesisimplant")
//    public String prosthesisimplant() {
//        return "dantista/procedure/prosthesisimplant";
//    }
//
//    @GetMapping("/ceramicrestoration")
//    public String ceramicrestoration() {
//        return "dantista/procedure/ceramicrestoration";
//    }
//
//    @GetMapping("/childrencaries")
//    public String childrencaries() {
//        return "dantista/procedure/childrencaries";
//    }
//
//    @GetMapping("/bridle")
//    public String bridle() {
//        return "dantista/procedure/bridle";
//    }
//    @GetMapping("/fissure")
//    public String fissure() {
//        return "dantista/procedure/fissure";
//    }
//
//    @GetMapping("/removableprosthetics")
//    public String removableprosthetics() {
//        return "dantista/procedure/removableprosthetics";
//    }
//
//    @GetMapping("/homebleaching")
//    public String homebleaching() {
//        return "dantista/procedure/homebleaching";
//    }
//
//    @GetMapping("/anesthesiainjection")
//    public String anesthesiainjection() {
//        return "dantista/procedure/anesthesiainjection";
//    }
//    @GetMapping("/xray")
//    public String xray() {
//        return "dantista/procedure/xray";
//    }
//
//    @GetMapping("/treatmentplan")
//    public String treatmentplan() {
//        return "dantista/procedure/treatmentplan";
//    }
//
//    @GetMapping("/curettage")
//    public String curettage() {
//        return "dantista/procedure/curettage";
//    }
//
//    @GetMapping("/periodontalmap")
//    public String periodontalmap() {
//        return "dantista/procedure/periodontalmap";
//    }
//
//    @GetMapping("/initialconsultation")
//    public String initialconsultation() {
//        return "dantista/procedure/initialconsultation";
//    }
//
//    @GetMapping("/orthodonticappliances")
//    public String orthodonticappliances() {
//        return "dantista/procedure/orthodonticappliances";
//    }
//
//    @GetMapping("/endobleaching")
//    public String endobleaching() {
//        return "dantista/procedure/endobleaching";
//    }
//
//    @GetMapping("/cofferdam")
//    public String cofferdam() {
//        return "dantista/procedure/cofferdam";
//    }
//    @GetMapping("/bugel")
//    public String bugel() {
//        return "dantista/procedure/bugel";
//    }
//    @GetMapping("/implant")
//    public String implant() {
//        return "dantista/procedure/implant";
//    }
//    @GetMapping("/crowns")
//    public String crowns() {
//        return "dantista/procedure/crowns";
//    }

    @RequestMapping("/robots.txt")
    @ResponseBody
    public String robots() {
        try {
            File robotsTxt = new File("../resources/templates/dantista/robot.txt");
            return new String(Files.readAllBytes(robotsTxt.toPath()));
        } catch (IOException e) {
            return "User-agent: *" + System.lineSeparator() +
                    "Disallow: /admin";
        }
    }

    @RequestMapping("/sitemap.xml")
    public void sitemap(HttpServletResponse response) throws IOException {
        PrintWriter w = response.getWriter();
        boolean isSitemapAlreadyCreated = sitemapDirectory != null;
        if (isSitemapAlreadyCreated) {
            pipeSitemapToResponse(w);
            return;
        }
        sitemapDirectory = Files.createTempDirectory("mySitemap");
        WebSitemapGenerator wsg = new WebSitemapGenerator("https://dentme.if.ua/", sitemapDirectory.toFile());
        wsg.addUrl("https://dentme.if.ua/");
        wsg.write();
        pipeSitemapToResponse(w);
    }

    private void pipeSitemapToResponse(PrintWriter w) {
//        Path sitemap = Paths.get("../../../../../../../resources/static/", "sitemap.xml");
        Path sitemap = Paths.get(sitemapDirectory.toString(), "sitemap.xml");
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(sitemap, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                w.write(line);
            }
        } catch (IOException e) {
            System.out.println("Failed to read the sitemap file.");
        }
    }
}
