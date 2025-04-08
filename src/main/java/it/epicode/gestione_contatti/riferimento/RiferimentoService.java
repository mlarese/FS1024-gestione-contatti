package it.epicode.gestione_contatti.riferimento;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

//@Component usiamo service - figlia di component nel caso delle classi helper
@Service

// serve a creare una variabile log all'interno dei metodi
@Slf4j
public class RiferimentoService {
    @Autowired
    private Faker faker;
    @Autowired
    private RiferimentoRepository riferimentoRepository;

    @Getter
    private Set<Riferimento> riferimenti = new HashSet<>();
    public void createData() {

        // questa variabile viene creata da lombok dopo aver inserito @Slf4j
        log.info("inizio creazione");
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
    }

}
