package com.example.demo.tset.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;






@Controller
public class TestController {
    
    @RequestMapping("/index.kdt")
    public String index(Model model) {
        System.out.println("debug >>> test controller index:/index.kdt");
        model.addAttribute("msg","처음으로 만나는 스프링 부트");
        return "index";
    }

    
    
    
}
