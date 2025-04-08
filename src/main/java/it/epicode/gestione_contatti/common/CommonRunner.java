package it.epicode.gestione_contatti.common;

import it.epicode.gestione_contatti.aziende.AziendaService;
import it.epicode.gestione_contatti.persone.ContattoService;
import it.epicode.gestione_contatti.riferimento.RiferimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommonRunner  implements CommandLineRunner {
    @Autowired
    private RiferimentoService riferimentoService;
    @Autowired
    private ContattoService contattoService;

    @Autowired
    private AziendaService aziendaService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------");
        System.out.println("Creazione dati");
        riferimentoService.createData();
        contattoService.createData(riferimentoService.getRiferimenti());
        aziendaService.createData(riferimentoService.getRiferimenti());

    }
}
