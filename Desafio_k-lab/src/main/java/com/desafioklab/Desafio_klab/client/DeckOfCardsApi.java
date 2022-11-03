package com.desafioklab.Desafio_klab.client;

import com.desafioklab.Desafio_klab.model.response.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "DeckOfCardsapi", url = "https://deckofcardsapi.com/")
public interface DeckOfCardsApi {

    @RequestMapping(method = RequestMethod.GET, value = "api/deck/{deck_id}/draw/?count={count}"    )
    Root getDeck(@PathVariable("deck_id") String deckId, @PathVariable("count") int count);

}
