package com.desafioklab.Desafio_klab.service;


import com.desafioklab.Desafio_klab.client.DeckOfCardsApi;
import com.desafioklab.Desafio_klab.enums.Cards;
import com.desafioklab.Desafio_klab.model.response.Card;
import com.desafioklab.Desafio_klab.model.response.Jogador;
import com.desafioklab.Desafio_klab.model.response.Jogo;
import com.desafioklab.Desafio_klab.model.response.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeckOfCardsServices {

    @Autowired
    DeckOfCardsApi deckOfCardsApi;

    public Jogo jogarBaralhoComQuatroJogadores(){
        String deckId = "new";
        int maiorNumeroDeCartas =  -1;
        int jogadorVencedor = -1;
        List<String> ecardsToNumber = Arrays.stream(Cards.values()).map(c -> c.name()).toList();
        List<Jogador> jogadors = new ArrayList<>();
        Jogo jogo = new Jogo();
        for (int i = 1; i <=4; i++){
            Root cards = deckOfCardsApi.getDeck(deckId,4);
            if(cards.getSuccess()){
                deckId = cards.getDeckId();
                int soma = getSomaCartas(ecardsToNumber, i, cards);
                Jogador jogador = new Jogador(i, soma,cards.getCards());
                if(soma > maiorNumeroDeCartas){
                    maiorNumeroDeCartas = soma;
                    jogadorVencedor = i;
                }
                jogadors.add(jogador);
            }

        }
        jogo.setNumeroDoDeck(deckId);
        jogo.setJogadorVencedor(String.valueOf(jogadorVencedor));
        jogo.setJogadorList(jogadors);
        jogo.setPontosJogadorVencedor(String.valueOf(maiorNumeroDeCartas));
        return jogo;

    }

    private static int getSomaCartas(List<String> ecardsToNumber, int i, Root cards) {
        int soma = 0;
        for (Card card: cards.getCards()) {

            if(ecardsToNumber.contains(card.getValue())){
                soma = getValueOfCardsWithNames(soma, card);
            }else{
                soma += Integer.valueOf(card.getValue());
            }
        }
        return soma;
    }

    private static int getValueOfCardsWithNames(int soma, Card card) {
        for (Cards cardEnum: Cards.values()) {
            if(cardEnum.name().equals(card.getValue())){
                soma += cardEnum.getValor();
            }
        }
        return soma;
    }

}
