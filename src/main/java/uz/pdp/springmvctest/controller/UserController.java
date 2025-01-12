package uz.pdp.springmvctest.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springmvctest.model.User;

import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 10/01/25 21:01
 **/
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final EntityManagerFactory entityManagerFactory;

    // GET: All Users
    @GetMapping
    public ModelAndView read() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
            return new ModelAndView("user").addObject("users", users);
        } finally {
            entityManager.close();
        }
    }

    // POST: Create New User
    @PostMapping
    public ModelAndView create(@ModelAttribute User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return read();
        } finally {
            entityManager.close();
        }
    }

    // POST: Delete User by ID
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
            entityManager.getTransaction().commit();
            return read();
        } finally {
            entityManager.close();
        }
    }

    // POST: Update User
    @PostMapping("/update/{id}")
    public ModelAndView update(@PathVariable Integer id, @ModelAttribute User updatedUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, id);
            if (user != null) {
                user.setName(updatedUser.getName());
                user.setAge(updatedUser.getAge());
                entityManager.merge(user);
            }
            entityManager.getTransaction().commit();
            return read();
        } finally {
            entityManager.close();
            System.out.println("Updated user: " + updatedUser);
        }
    }
}
