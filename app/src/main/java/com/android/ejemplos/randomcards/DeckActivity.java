package com.android.ejemplos.randomcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DeckActivity extends AppCompatActivity {

    private TextView remainingText;
    private ImageView cardImage;
    int remainingCard;
    String deckIdentifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);

        remainingText = (TextView) findViewById(R.id.activity_card___number_cards_textview);
        cardImage = (ImageView) findViewById(R.id.activity_card___card_image);

        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCard();
            }
        });

        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCard();
            }
        });
    }

    public void displayCard() {
        final DeckOfCardsAPI deckOfCardsAPI = new DeckOfCardsAPI();
        if(remainingCard == 0) {
            deckIsEmpty(deckOfCardsAPI);
        } else {
            printCard(deckOfCardsAPI);
        }
    }

    private void deckIsEmpty(final DeckOfCardsAPI deckOfCardsAPI) {
        deckOfCardsAPI.getNewDeck(getApplicationContext());

        deckOfCardsAPI.setOnDeckDownloadDataFinished(new DeckOfCardsAPI.DeckDownloadDataFinished() {
            @Override
            public void newDeckOfCardsData(String deckId) {
                deckIdentifier = deckId;
                printCard(deckOfCardsAPI);
            }
        });
    }

    private void printCard(DeckOfCardsAPI deckOfCardsAPI) {
        deckOfCardsAPI.getNextCard(getApplicationContext(), deckIdentifier);
        deckOfCardsAPI.setOnCardDownloadDataFinished(new DeckOfCardsAPI.CardDownloadDataFinished() {
            @Override
            public void newCardData(String urlImage, String deckId, int remaining) {

                remainingText.setText(getResources().getString(R.string.activity_card___remaining_text) + remaining);
                Picasso.with(getApplicationContext()).load(urlImage).placeholder(R.drawable.back).into(cardImage);
                remainingCard = remaining;
            }
        });
    }
}