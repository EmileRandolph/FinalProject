package com.example.checkoutservice.restcontrollers;

import com.example.checkoutservice.objects.CardInfo;
import com.example.checkoutservice.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Card")
public class CardRestController {
    @Autowired
    private CardRepository cardRepo;
    @PostMapping(path="")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody CardInfo card){
        CardInfo newCard = new CardInfo(card.getUserId(), card.getCardNumber(), card.getCardExperationDate(), card.getCVV());
        cardRepo.save(newCard);
    }
}

