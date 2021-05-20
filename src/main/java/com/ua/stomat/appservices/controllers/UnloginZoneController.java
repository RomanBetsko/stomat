package com.ua.stomat.appservices.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UnloginZoneController {

    private Path sitemapDirectory;

    @GetMapping("/{locale:en|ru|pl|uk}/")
    public ModelAndView internationalIndex(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/index", params);
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "security/403";
    }

//    @GetMapping("/doctor")
//    public String doctor() {
//        return "dantista/doctor";
//    }

    @GetMapping("/{locale:en|ru|pl|uk}/about")
    public ModelAndView about(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/about", params);
    }

    //Blog items
    @GetMapping("/{locale:en|ru|pl|uk}/blog")
    public ModelAndView blog(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/blog", params);
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
    @GetMapping("/{locale:en|ru|pl|uk}/contact")
    public ModelAndView contact(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "contact");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/contact", params);
    }


    @GetMapping("/{locale:en|ru|pl|uk}/services")
    public ModelAndView services(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/services", params);
    }

    // List of services 9 pieces

    @GetMapping("/{locale:en|ru|pl|uk}/therapeutic")
    public ModelAndView therapeutic(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/therapeutic", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/pediatric")
    public ModelAndView pediatric(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/pediatric", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/surgery")
    public ModelAndView surgery(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/surgery", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/bleaching")
    public ModelAndView bleaching(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/bleaching", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/orthodontics")
    public ModelAndView orthodontics(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/orthodontics", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/prosthesis")
    public ModelAndView prosthesis(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/prosthesis", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/lazer")
    public ModelAndView lazer(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/lazer", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/primary")
    public ModelAndView primary(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/primary", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/periodontics")
    public ModelAndView periodontics(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/periodontics", params);
    }

    // List of procedures

    @GetMapping("/{locale:en|ru|pl|uk}/philipszoom")
    public ModelAndView philipszoom(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/procedure/philipszoom", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/hygiene")
    public ModelAndView hygiene(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/procedure/hygiene", params);
    }

    @GetMapping("/{locale:en|ru|pl|uk}/removal")
    public ModelAndView removal(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("currentURL", "services");
        params.put("currentLang", StringUtils.substring(request.getRequestURI(), 1, 3));
        return new ModelAndView("dantista/procedure/removal", params);
    }

    @GetMapping("/")
    public RedirectView redirectView() {
        return new RedirectView("/uk/");
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

//    @RequestMapping("/sitemap.xml")
//    public void sitemap(HttpServletResponse response) throws IOException {
//        PrintWriter w = response.getWriter();
//        boolean isSitemapAlreadyCreated = sitemapDirectory != null;
//        if (isSitemapAlreadyCreated) {
//            pipeSitemapToResponse(w);
//            return;
//        }
//        sitemapDirectory = Files.createTempDirectory("mySitemap");
//        WebSitemapGenerator wsg = new WebSitemapGenerator("https://dentme.if.ua/", sitemapDirectory.toFile());
//        wsg.addUrl("https://dentme.if.ua/");
//        wsg.write();
//        pipeSitemapToResponse(w);
//    }
//
//    private void pipeSitemapToResponse(PrintWriter w) {
////        Path sitemap = Paths.get("../../../../../../../resources/static/", "sitemap.xml");
//        Path sitemap = Paths.get(sitemapDirectory.toString(), "sitemap.xml");
//        Charset charset = Charset.forName("UTF-8");
//        try (BufferedReader reader = Files.newBufferedReader(sitemap, charset)) {
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                w.write(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Failed to read the sitemap file.");
//        }
//    }
}
