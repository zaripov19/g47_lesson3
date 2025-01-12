package uz.pdp.springmvctest.controller;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springmvctest.config.DataSource;
import uz.pdp.springmvctest.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 08/01/25 19:44
 **/
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final DataSource dataSource;

//    List<User> users = new ArrayList<>(List.of(
//            new User(1,"John"),
//            new User(2,"Doe"),
//            new User(3,"Black")
//    ));

    @GetMapping("/home")
    public ModelAndView home() {

        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        List<User> users = entityManager.createQuery("select u from users u", User.class)
                .getResultList();

        ModelAndView view = new ModelAndView("home");
        view.addObject("username", "Bu backenddan kelyapti");
        view.addObject("users", users);
        return view;
    }

}
