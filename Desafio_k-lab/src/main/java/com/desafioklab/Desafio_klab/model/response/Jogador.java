package com.desafioklab.Desafio_klab.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {

    @JsonProperty("numeroJogador")
    private int numeroJogador;

    @JsonProperty("pontos")
    private int somaDeCartas;

    @JsonProperty("cartas")
    private List<Card> maoDoJogadors;



}
