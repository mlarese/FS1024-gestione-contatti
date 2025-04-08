package it.epicode.gestione_contatti.riferimento;

import it.epicode.gestione_contatti.persone.Contatto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "riferimenti")
public class Riferimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String cognome;
    @Column(nullable = false, length = 50)
    private String ruolo;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(length = 50)
    private String telefono;

    @OneToMany(mappedBy = "riferimento")
    private List<Contatto> contatti = new ArrayList<>();
}
