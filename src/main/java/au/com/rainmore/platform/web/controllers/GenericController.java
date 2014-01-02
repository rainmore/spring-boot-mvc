package au.com.rainmore.platform.web.controllers;

import org.springframework.web.servlet.ModelAndView;

public abstract class GenericController {
    private static final String REDIRECT_TEMPLATE = "redirect:%s";

    protected static String redirect(String view) {
        return String.format(REDIRECT_TEMPLATE, view);
    }
}
