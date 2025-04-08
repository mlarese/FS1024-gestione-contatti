package it.epicode.gestione_contatti.common;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class CommonConfig {

    @Bean
    public Faker faker() {
        return new Faker( Locale.FRANCE );
    }
}
