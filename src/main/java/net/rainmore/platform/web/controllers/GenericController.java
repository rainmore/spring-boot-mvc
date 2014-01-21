package net.rainmore.platform.web.controllers;

public abstract class GenericController {
    private static final String REDIRECT_TEMPLATE = "redirect:%s";
    private static final String FORWARD_TEMPLATE = "forward:%s";

    protected static String redirect(String view) {
        return String.format(REDIRECT_TEMPLATE, view);
    }

    protected static String forward(String view) {
        return String.format(FORWARD_TEMPLATE, view);
    }
}
