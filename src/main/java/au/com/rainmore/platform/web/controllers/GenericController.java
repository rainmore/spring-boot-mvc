package au.com.rainmore.platform.web.controllers;

import org.springframework.web.servlet.ModelAndView;

public abstract class GenericController {

    protected ModelAndView redirect(String view) {
        return new ModelAndView(String.format("redirect:%s", view));
    }
}
