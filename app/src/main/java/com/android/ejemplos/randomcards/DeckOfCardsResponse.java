package com.android.ejemplos.randomcards;

import com.google.gson.annotations.SerializedName;

public class DeckOfCardsResponse {
    private @SerializedName("remaining") int deckOfCardsRemaining;
    private @SerializedName("success") boolean deckOfCardsSuccess;
    private @SerializedName("deck_id") String deckOfCardsDeckId;
    private @SerializedName("shuffled") boolean deckOfCardsShuffled;

    public boolean isDeckOfCardsShuffled() {
        return deckOfCardsShuffled;
    }

    public void setDeckOfCardsShuffled(boolean deckOfCardsShuffled) {
        this.deckOfCardsShuffled = deckOfCardsShuffled;
    }

    public int getDeckOfCardsRemaining() {
        return deckOfCardsRemaining;
    }

    public void setDeckOfCardsRemaining(int deckOfCardsRemaining) {
        this.deckOfCardsRemaining = deckOfCardsRemaining;
    }

    public boolean isDeckOfCardsSuccess() {
        return deckOfCardsSuccess;
    }

    public void setDeckOfCardsSuccess(boolean deckOfCardsSuccess) {
        this.deckOfCardsSuccess = deckOfCardsSuccess;
    }

    public String getDeckOfCardsDeckId() {
        return deckOfCardsDeckId;
    }

    public void setDeckOfCardsDeckId(String deckOfCardsDeckId) {
        this.deckOfCardsDeckId = deckOfCardsDeckId;
    }
}
