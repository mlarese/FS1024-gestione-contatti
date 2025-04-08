package it.epicode.gestione_contatti.aziende;

import it.epicode.gestione_contatti.riferimento.Riferimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AziendaService {
    @Autowired
    private Azienda luxottica;
    @Autowired
    private AziendaRepository aziendaRepository;

    public void createData(Set<Riferimento> riferimenti) {
        luxottica.setRiferimenti(riferimenti);
        aziendaRepository.save(luxottica);
    }
}
