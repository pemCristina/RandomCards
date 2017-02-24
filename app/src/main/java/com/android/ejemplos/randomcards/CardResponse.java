package com.android.ejemplos.randomcards;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardResponse {
    private @SerializedName("remaining") int CardResponseRemaining;
    private @SerializedName("success") boolean CardResponseSuccess;
    private @SerializedName("deck_id") String CardResponseDeckId;
    private @SerializedName("cards") List<Cards> CardResponseCards;

    public int getCardResponseRemaining() {
        return CardResponseRemaining;
    }

    public void setCardResponseRemaining(int cardResponseRemaining) {
        CardResponseRemaining = cardResponseRemaining;
    }

    public boolean isCardResponseSuccess() {
        return CardResponseSuccess;
    }

    public void setCardResponseSuccess(boolean cardResponseSuccess) {
        CardResponseSuccess = cardResponseSuccess;
    }

    public String getCardResponseDeckId() {
        return CardResponseDeckId;
    }

    public void setCardResponseDeckId(String cardResponseDeckId) {
        CardResponseDeckId = cardResponseDeckId;
    }

    public List<Cards> getCardResponseCards() {
        return CardResponseCards;
    }

    public void setCardResponseCards(List<Cards> cardResponseCards) {
        CardResponseCards = cardResponseCards;
    }

    public class Cards {
        private @SerializedName("suit") String CardsSuit;
        private @SerializedName("image") String CardsImage;
        private @SerializedName("images") Images CardsImages;
        private @SerializedName("code") String CardsCode;
        private @SerializedName("value") String CardsValue;

        public String getCardsSuit() {
            return CardsSuit;
        }

        public void setCardsSuit(String cardsSuit) {
            CardsSuit = cardsSuit;
        }

        public String getCardsImage() {
            return CardsImage;
        }

        public void setCardsImage(String cardsImage) {
            CardsImage = cardsImage;
        }

        public String getCardsCode() {
            return CardsCode;
        }

        public void setCardsCode(String cardsCode) {
            CardsCode = cardsCode;
        }

        public String getCardsValue() {
            return CardsValue;
        }

        public void setCardsValue(String cardsValue) {
            CardsValue = cardsValue;
        }

        public Images getCardsImages() {
            return CardsImages;
        }

        public void setCardsImages(Images cardsImages) {
            CardsImages = cardsImages;
        }
    }

    public class Images {
        private @SerializedName("svg") String ImagesSvg;
        private @SerializedName("png") String ImagesPng;

        public String getImagesSvg() {
            return ImagesSvg;
        }

        public void setImagesSvg(String imagesSvg) {
            ImagesSvg = imagesSvg;
        }

        public String getImagesPng() {
            return ImagesPng;
        }

        public void setImagesPng(String imagesPng) {
            ImagesPng = imagesPng;
        }
    }
}


