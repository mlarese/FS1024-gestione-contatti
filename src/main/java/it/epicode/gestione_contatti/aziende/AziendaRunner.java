package it.epicode.gestione_contatti.aziende;

import com.github.javafaker.Faker;
import it.epicode.gestione_contatti.persone.Contatto;
import it.epicode.gestione_contatti.persone.ContattoRepository;
import it.epicode.gestione_contatti.riferimento.Riferimento;
import it.epicode.gestione_contatti.riferimento.RiferimentoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

// commentando component questo runner non parte più all'avvio dell'applicazione
//@Component
// viene eseguito il common runner questa classe è obsoleta
public class AziendaRunner implements CommandLineRunner {
    @Autowired private Azienda luxotticaSpa;
    @Autowired private AziendaRepository aziendaRepository;
    @Autowired private ContattoRepository contattoRepository;
    @Autowired private RiferimentoRepository riferimentoRepository;
    @Autowired private Faker faker;


    @Value("${app.creazionedb.titolo}")
    private String titolo;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------");
        System.out.println(titolo);
        System.out.println("------");

        Set<Riferimento> riferimenti = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            Riferimento riferimento = new Riferimento();
            riferimento.setNome(faker.name().firstName());
            riferimento.setCognome(faker.name().lastName());
            riferimento.setEmail(faker.internet().emailAddress());
            riferimento.setTelefono(faker.phoneNumber().phoneNumber());
            riferimento.setRuolo(faker.job().title());

            riferimentoRepository.save(riferimento);

            riferimenti.add(riferimento);

        }

        luxotticaSpa.setRiferimenti(riferimenti);
        aziendaRepository.save(luxotticaSpa);

        for (int i = 0; i < 100; i++) {
            Contatto contatto = new Contatto();
            contatto.setNome(faker.name().firstName());
            contatto.setCognome(faker.name().lastName());
            contatto.setEmail(faker.internet().emailAddress());
            contatto.setTelefono(faker.phoneNumber().phoneNumber());

            contatto.setRiferimento(
                    riferimenti.stream()  // crea uno stream dalla lista 'riferimenti'
                            .skip((int) (riferimenti.size() * Math.random())) // salta un numero casuale di elementi
                            .findFirst()  // prende il primo elemento dopo lo skip
                            .orElse(null)  // se non c'è nessun elemento (lista vuota o skip troppo alto), usa null
            );

            contattoRepository.save(contatto);


        }

    }
}
