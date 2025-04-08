package it.epicode.gestione_contatti.aziende;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AziendaConfig {

    @Bean
    public Azienda luxotticaSpa() {
        Azienda a = new Azienda();
        a.setRagioneSociale("Luxottica Group S.p.A.");
        a.setPartitaIva("0987654321");
        a.setEmail("luxotticagroup@sp.com");
        a.setTelefono("1234567890");
        a.setIndirizzo("Via Verdi, 1");
        a.setCitta("Roma");
        a.setProvincia("RM");
        a.setCap("00100");
        return a;
    }


}
