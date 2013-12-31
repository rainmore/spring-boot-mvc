package au.com.rainmore.platform.web.controllers;

import au.com.rainmore.platform.web.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DefaultController {
    private final Logger LOG = LoggerFactory.getLogger(DefaultController.class);

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

    @RequestMapping(value = "/form")
    public String formView(final Person person, final BindingResult bindingResult) throws Exception {
        person.setFirstName("Felix");
        person.setLastName("Rong");
        person.setMiddleName("Jie");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = dateFormat.parse("2000-01-01");

        person.setDateOfBirth(dateOfBirth);
        LOG.info(String.format("get, person: %s", person.toString()));
        return "form";
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String formProcess(final Person person, final BindingResult bindingResult) {
        LOG.info(String.format("post, person: %s", person.toString()));
        if (person.getDateOfBirth() != null)
            LOG.info(String.format("post, person: %s", person.getDateOfBirth().toString()));
        return "form";
    }


}
