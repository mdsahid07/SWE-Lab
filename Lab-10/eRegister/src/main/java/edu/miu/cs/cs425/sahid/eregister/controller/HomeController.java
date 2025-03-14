package edu.miu.cs.cs425.sahid.eregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping(value={"","/","/home"})
    public String homePage() {
        return "home";
    }
}
