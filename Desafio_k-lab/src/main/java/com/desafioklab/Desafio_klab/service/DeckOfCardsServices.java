package com.desafioklab.Desafio_klab.service;

import com.desafioklab.Desafio_klab.client.DeckOfCardsApi;
import com.desafioklab.Desafio_klab.enums.Cards;
import com.desafioklab.Desafio_klab.model.response.Card;
import deck.entities.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DeckOfCardsServices {

    @Autowired
    DeckOfCardsApi deckOfCardsApi;

    public void jogarBaralhoComQuatroJogadores(){
        String deckId = "new";
        int maiorNumeroDeCartas =  -1;
        int jogadorVencedor = -1;
        List<String> ecardsToNumber = Arrays.asList(Cards.ACE.name(), Cards.JACK.name(), Cards.KING.name(), Cards.QUEEN.name());
        for (int i = 0; i <4; i++){
           Root cards = deckOfCardsApi.getDeck(deckId,4);
           if(cards.getSuccess()){
               deckId = cards.getDeck_id();
               int soma = getSomaCartas(ecardsToNumber, i, cards);
               if(soma > maiorNumeroDeCartas){
                   jogadorVencedor = i;
               }
           }
        }
        System.out.println("Vencedor jogador " + jogadorVencedor);

    }

    private static int getSomaCartas(List<String> ecardsToNumber, int i, Root cards) {
        int soma = 0;
        for (Card card:
             cards.getCards()) {
            System.out.println("Jogador " + i + " com carta " + card.getValue());

            if(ecardsToNumber.contains(card.getValue())){
                soma = getValueOfCardsWithNames(soma, card);
            }else{
                soma += Integer.valueOf(card.getValue());
            }
        }
        return soma;
    }

    private static int getValueOfCardsWithNames(int soma, Card card) {
        for (Cards cardEnum:
             Cards.values()) {
            if(cardEnum.name().equals(card.getValue())){
                soma += cardEnum.getValor();
            }
        }
        return soma;
    }

}
