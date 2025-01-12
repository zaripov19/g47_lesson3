package uz.pdp.springmvctest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springmvctest.config.DataSource;
import uz.pdp.springmvctest.model.User;

import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 10/01/25 19:39
 **/
@Controller
@RequestMapping("/thymeleaf")
@RequiredArgsConstructor
public class ThymeLeafController {
    private final DataSource dataSource;

    @GetMapping("/simple-expresion")// /thymeleaf/simple-expresion
    public ModelAndView simpleExpression() {
        ModelAndView modelAndView = new ModelAndView("simpleExpression");

        modelAndView.addObject("name", "John");
        modelAndView.addObject("user1", new User(1, "Valijon", 19));

        List<User> users = dataSource.getEntityManagerFactory()
                .createEntityManager()
                .createQuery("select u from users u", User.class)
                .getResultList();

        modelAndView.addObject("users", users);

        return modelAndView;
    }

}
