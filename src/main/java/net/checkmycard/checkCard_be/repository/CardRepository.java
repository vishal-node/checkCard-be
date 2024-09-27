package net.checkmycard.checkCard_be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.checkmycard.checkCard_be.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCardNumber(String cardNumber);

    Card findByCardHolderName(String cardHolderName);

    Card findByCardNumberAndCardHolderName(String cardNumber, String cardHolderName);
}
