package net.rainmore.platform.web.controllers;

import net.rainmore.platform.web.config.jpa.PageWrapper;
import net.rainmore.platform.web.persistent.models.Person;
import net.rainmore.platform.web.persistent.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    public String home(ModelMap modelMap, Pageable pageable) {
        PageWrapper<Person> page = new PageWrapper<Person>(personService.findAll(pageable), "/");
        modelMap.addAttribute("page", page);
        return "list";
    }

    @RequestMapping(value = "/form")
    public String formView(@RequestParam(value = "id", required = false, defaultValue = "")Long id, ModelMap modelMap) throws Exception {
        Person person = new Person();
        if (id != null && id > 0) {
            person = personService.findOne(id);
        }

        modelMap.addAttribute("person", person);
        LOG.info(String.format("get, person: %s", person.toString()));
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String formProcess(@Valid final Person person, final BindingResult bindingResult) {
        LOG.info(String.format("post, person: %s", person.toString()));
        if (bindingResult.hasErrors()) {
            return "form";
        }
        personService.save(person);
        return redirect("form?id=" + person.getId());
    }


}
