package uz.pdp.springmvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 Created by: Mehrojbek
 DateTime: 08/01/25 19:44
 **/
@Controller
@ResponseBody
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
