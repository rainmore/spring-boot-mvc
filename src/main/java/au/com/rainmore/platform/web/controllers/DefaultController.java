package au.com.rainmore.platform.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap, @RequestParam("name") String name) throws Exception {
        modelMap.addAttribute("hello", "hello------");

        if ( name.isEmpty()) {
            throw new Exception("A Test for exception handler");
        }

        return "hello";
    }

    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("hello", "hello------");
        return "hello";
    }

}
