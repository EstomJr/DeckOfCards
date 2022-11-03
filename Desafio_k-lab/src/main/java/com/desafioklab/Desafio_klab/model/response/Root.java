package com.desafioklab.Desafio_klab.response;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "deck_id",
        "cards",
        "remaining"
})
@Generated("jsonschema2pojo")
public class Root {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("deck_id")
    private String deckId;
    @JsonProperty("cards")
    private List<Card> cards = null;
    @JsonProperty("remaining")
    private Integer remaining;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("deck_id")
    public String getDeckId() {
        return deckId;
    }

    @JsonProperty("deck_id")
    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    @JsonProperty("cards")
    public List<Card> getCards() {
        return cards;
    }

    @JsonProperty("cards")
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @JsonProperty("remaining")
    public Integer getRemaining() {
        return remaining;
    }

    @JsonProperty("remaining")
    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}