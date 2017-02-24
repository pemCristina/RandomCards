package com.android.ejemplos.randomcards;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;

public class DeckOfCardsAPI {

    public interface DeckDownloadDataFinished {
        void newDeckOfCardsData(String deckId); // Quiero que me comuniques los datos (nombre y temperatura) cuando termines
    }
    public interface CardDownloadDataFinished {
        void newCardData(String urlImage, String deckId, int remaining);
    }

    private DeckDownloadDataFinished listenerDeck;
    private CardDownloadDataFinished listenerCard;


    public void setOnDeckDownloadDataFinished(DeckDownloadDataFinished listenerDeck) {
        this.listenerDeck = listenerDeck;
    }

    public void setOnCardDownloadDataFinished(CardDownloadDataFinished listenerCard) {
        this.listenerCard = listenerCard;
    }

    public void getNewDeck(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Constants.CREATE_DECK_URL;
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("queue deck", response);
                parseDeckOfCardsJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("queue deck  ", "Error connecting");
            }
        });
        queue.add(request);
    }

    public void getNextCard(Context context, String deckId) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Constants.GET_CARD_BASE_URL_FIRST + deckId + Constants.GET_CARD_BASE_URL_LAST;
        Log.e("Uurl next card", url);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("queue card", response);
                parseCardJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("queue card", "Error connecting");
            }
        });
        queue.add(request);
    }

    private void parseDeckOfCardsJSON(String response) {
        Gson gson = new GsonBuilder().create();     // Va a leer la respuesta y la va a convertir en objeto
        Reader reader = new StringReader(response); // StringReader Permite recorrer una cadena de texto linea a linea
        DeckOfCardsResponse deck = gson.fromJson(reader, DeckOfCardsResponse.class);
        Log.d("deck response", deck.toString());

        if(listenerDeck != null) {
            listenerDeck.newDeckOfCardsData(deck.getDeckOfCardsDeckId());
        }
    }

    private void parseCardJSON(String response) {
        Gson gson = new GsonBuilder().create();     // Va a leer la respuesta y la va a convertir en objeto
        Reader reader = new StringReader(response); // StringReader Permite recorrer una cadena de texto linea a linea
        CardResponse card = gson.fromJson(reader, CardResponse.class);
        Log.d("card response", card.toString());

        if(listenerCard != null) {
            listenerCard.newCardData(card.getCardResponseCards().get(0).getCardsImages().getImagesPng(), card.getCardResponseDeckId(), card.getCardResponseRemaining());
        }
    }
}