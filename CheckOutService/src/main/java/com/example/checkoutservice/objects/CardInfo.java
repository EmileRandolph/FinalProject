package com.example.checkoutservice.objects;

import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class CardInfo {
    @Id
    private UUID cardId;
    @Nonnull
    private UUID UserId;
    @Nonnull
    private String cardNumber;
    @Nonnull
    private String cardExperationDate;
    @Nonnull
    private int CVV;

    public CardInfo( UUID userId, String cardNumber, String cardExperationDate, int CVV) {
        cardId = UUID.randomUUID();
        UserId = userId;
        this.cardNumber = cardNumber;
        this.cardExperationDate = cardExperationDate;
        this.CVV = CVV;
    }

    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
    }

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if(cardNumber.charAt(0)=='5'|| cardNumber.charAt(0)=='4'){
            this.cardNumber = cardNumber;
        }else{
            throw new IllegalArgumentException("Card is invalid");
        }
    }

    public String getCardExperationDate() {
        return cardExperationDate;
    }

    public void setCardExperationDate(String cardExperationDate) {
        this.cardExperationDate = cardExperationDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
}
