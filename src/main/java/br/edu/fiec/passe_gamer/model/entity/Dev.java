package br.edu.fiec.passe_gamer.model.entity;

import br.edu.fiec.passe_gamer.model.dto.DevDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Desenvolvedores")
public class Dev {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String desenvolvedores;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String jogos;

    public Dev(String tipo, DevDTO devDTO) {
        setTipo(tipo);
        setDesenvolvedores(devDTO.getDesenvolvedores());
        setGenero(devDTO.getGenero());
        setJogos(devDTO.getJogos());
    }
}
