package net.checkmycard.checkCard_be.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.checkmycard.checkCard_be.model.Card;
import net.checkmycard.checkCard_be.service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Card> createCardData(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.createCardData(card));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Card> updateCardById(@PathVariable Long id, @RequestBody Card card) {
        Optional<Card> updatedCard = cardService.updateCardById(id, card);
        if (updatedCard.isPresent()) {
            return ResponseEntity.ok(updatedCard.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCardById(@PathVariable Long id) {
        cardService.deleteCardById(id);
        return ResponseEntity.noContent().build();
    }
}
