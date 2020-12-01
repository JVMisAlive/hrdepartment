package com.hr.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainViewController {

    @GetMapping("/mainpage")
    public ModelAndView viewMainPage() {
        return new ModelAndView("mainpage");
    }
}
