package au.com.rainmore.platform.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("hello", "hello------");
        return "hello";
    }

    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("hello", "hello------");
        return "hello";
    }
}
