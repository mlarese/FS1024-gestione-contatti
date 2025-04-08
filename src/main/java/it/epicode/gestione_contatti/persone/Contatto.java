package it.epicode.gestione_contatti.persone;

import it.epicode.gestione_contatti.riferimento.Riferimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contatti")
public class Contatto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String cognome;
    @Column(nullable = false, length = 50)
    private String email;
    @Column( length = 50)
    private String telefono;

    @ManyToOne
    private Riferimento riferimento;
}
