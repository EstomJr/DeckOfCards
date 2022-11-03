package com.desafioklab.Desafio_klab.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {

    @JsonProperty("jogador_vencedor")
    private String jogadorVencedor;

    @JsonProperty("pontos_jogador_vencedor")
    private String pontosJogadorVencedor;

    @JsonProperty("deck_id")
    private String numeroDoDeck;

    @JsonProperty("jogadores")
    private List<Jogador> jogadorList;
}
