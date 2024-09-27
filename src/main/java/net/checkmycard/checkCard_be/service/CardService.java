package net.checkmycard.checkCard_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.checkmycard.checkCard_be.model.Card;
import net.checkmycard.checkCard_be.repository.CardRepository;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public Card createCardData(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> updateCardById(Long id, Card card) {
        return cardRepository.findById(id).map(cardToUpdate -> {
            cardToUpdate.setBankName(card.getBankName()); // Example update field
            cardToUpdate.setCardHolderName(card.getCardHolderName());
            cardToUpdate.setCardNumber(card.getCardNumber());
            cardToUpdate.setCardType(card.getCardType());
            cardToUpdate.setExpiryDate(card.getExpiryDate());
            cardToUpdate.setCvv(card.getCvv());
            // Save the updated card back to the repository
            return cardRepository.save(cardToUpdate);
        });
    }

    public void deleteCardById(Long id) {
        cardRepository.deleteById(id);
    }

}
