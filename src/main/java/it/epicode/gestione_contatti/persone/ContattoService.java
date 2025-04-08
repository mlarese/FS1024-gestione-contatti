package it.epicode.gestione_contatti.persone;

import com.github.javafaker.Faker;
import it.epicode.gestione_contatti.riferimento.Riferimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContattoService {
    @Autowired
    private ContattoRepository contattoRepository;
    @Autowired
    private Faker faker;

    public void createData(Set<Riferimento> riferimenti) {
        for (int i = 0; i < 102; i++) {
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
