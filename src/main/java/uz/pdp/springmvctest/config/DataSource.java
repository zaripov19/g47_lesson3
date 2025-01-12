package uz.pdp.springmvctest.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Component;

/**
 Created by: Mehrojbek
 DateTime: 08/01/25 21:46
 **/
@Component
public class DataSource {

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public DataSource(){
        try {
            entityManagerFactory= Persistence.createEntityManagerFactory("spring_web_mvc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
