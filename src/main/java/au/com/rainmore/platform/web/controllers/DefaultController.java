package au.com.rainmore.platform.web.controllers;

import au.com.rainmore.platform.web.models.Person;
import au.com.rainmore.platform.web.services.PersonService;
import au.com.rainmore.platform.web.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DefaultController extends GenericController {
    private final Logger LOG = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    private PersonService personService;

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
        modelMap.addAttribute("dataList", personService.findAll());
        return "list";
    }

    @RequestMapping(value = "/form")
    public String formView(@RequestParam("id")Long id, ModelMap modelMap) throws Exception {
        Person person = personService.findOne(id);
        modelMap.addAttribute("person", person);
        LOG.info(String.format("get, person: %s", person.toString()));
        return "form";
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public ModelAndView formProcess(final Person person, final BindingResult bindingResult) {
        LOG.info(String.format("post, person: %s", person.toString()));
        personService.save(person);
        return redirect("form?id=" + person.getId());
    }


}
