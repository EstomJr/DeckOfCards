package com.desafioklab.Desafio_klab.controller;

import com.desafioklab.Desafio_klab.service.DeckOfCardsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckOfCardsController {

    @Autowired
    private DeckOfCardsServices deckOfCardsServices;

    @RequestMapping(value = "/jogo", method = RequestMethod.GET)
    public String jogar (){
        deckOfCardsServices.jogarBaralhoComQuatroJogadores();
        return "";
    }
}
