package it.epicode.gestione_contatti.aziende;

import it.epicode.gestione_contatti.riferimento.Riferimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aziende")
public class Azienda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 50)
    private String ragioneSociale;
    @Column(nullable = false, length = 50)
    private String partitaIva;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(length = 50)
    private String telefono;
    @Column(nullable = false, length = 50)
    private String indirizzo;
    @Column(nullable = false, length = 50)
    private String citta;
    @Column(nullable = false, length = 50)
    private String provincia;
    @Column(nullable = false, length = 10)
    private String cap;

    @OneToMany
    private Set<Riferimento> riferimenti = new HashSet<>();
}
