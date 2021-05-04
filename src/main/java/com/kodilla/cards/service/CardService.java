package com.kodilla.cards.service;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.domain.CardDto;
import com.kodilla.cards.mapper.CardMapper;
import com.kodilla.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    public List<Card> getAllCards() {return cardRepository.findAll(); }

    public List<CardDto> getCardsForCustomer(Long customerId) {
        List<Card> cards = cardRepository.findByCustomerId(customerId);
        return cardMapper.mapToCardsDto(cards);
    }
}
